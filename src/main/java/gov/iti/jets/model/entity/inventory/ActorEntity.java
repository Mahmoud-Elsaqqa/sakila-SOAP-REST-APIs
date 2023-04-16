package gov.iti.jets.model.entity.inventory;

import com.google.common.base.Objects;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.entity.FullName;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "actor")
@Table(name = "actor", schema = "sakila", indexes = {
        @Index(name = "idx_actor_last_name", columnList = "last_name")
})
@Data
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ActorEntity extends BaseEntity<ActorEntity> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private FullName fullName;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @OneToMany(mappedBy = "actorByActorId", cascade = CascadeType.ALL)
    private Collection<FilmActorEntity> filmActorsByActorId;

    public void update(ActorEntity entity) {
        this.fullName = entity.fullName;
        this.lastUpdate = entity.lastUpdate;
    }

//    public void addFilmActorsByActorId(FilmActorEntity filmActorEntity) {
//        if (filmActorEntity != null)
//            filmActorsByActorId.add(filmActorEntity);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEntity that = (ActorEntity) o;
        return Objects.equal(id, that.id)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, fullName, lastUpdate);
    }
}
