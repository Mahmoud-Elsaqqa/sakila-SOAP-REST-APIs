package gov.iti.jets.model.dto.inventory;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorModel extends BaseModel {
    private Integer actorId;

    private Integer filmId;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    @JsonbTransient
    private ActorModel actorByActorId;

    @ToString.Exclude
    @JsonbTransient
    private FilmModel filmByFilmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorModel that = (FilmActorModel) o;
        return Objects.equal(actorId, that.actorId)
                && Objects.equal(filmId, that.filmId)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actorId, filmId, lastUpdate);
    }
}
