package gov.iti.jets.model.entity.inventory;


import com.google.common.base.Objects;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorEntityPK implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
//    @Id
//    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
//            insertable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

//    @Id
//    @Column(name = "film_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false,
//            insertable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorEntityPK that = (FilmActorEntityPK) o;
        return Objects.equal(actorId, that.actorId)
                && Objects.equal(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actorId, filmId);
    }
}
