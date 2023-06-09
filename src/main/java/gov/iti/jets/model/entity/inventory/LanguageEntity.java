package gov.iti.jets.model.entity.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Language;
import gov.iti.jets.model.entity.BaseEntity;
import gov.iti.jets.model.mapping.converter.LanguageConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "language")
@Table(name = "language", schema = "sakila")
@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LanguageEntity extends BaseEntity<LanguageEntity> implements Serializable  {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "language_id", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Convert(converter = LanguageConverter.class)
    private Language id;

    @Basic
    @Column(name = "name", columnDefinition = "CHAR(20)", length = 20, nullable = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @Basic
    @Column(name = "last_update", columnDefinition = "TIMESTAMP", nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @NotNull
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "languageByLanguageId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<FilmEntity> filmsByLanguageId;

    @OneToMany(mappedBy = "languageByOriginalLanguageId", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<FilmEntity> filmsByOriginalLanguageId;

    public void update(LanguageEntity entity) {
        this.name = entity.name;
        this.lastUpdate = entity.lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageEntity that = (LanguageEntity) o;
        return id == that.id
                && Objects.equal(name, that.name)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, lastUpdate);
    }
}
