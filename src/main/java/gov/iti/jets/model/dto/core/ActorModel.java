package gov.iti.jets.model.dto.core;


import com.google.common.base.Objects;
import jakarta.json.bind.annotation.JsonbTransient;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorModel {
    private Integer actorId;

    private FullName fullName;

    private LocalDateTime lastUpdate;

    @JsonbTransient
    @ToString.Exclude
    private Collection<FilmActorModel> filmActorsByActorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorModel that = (ActorModel) o;
        return Objects.equal(actorId, that.actorId)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actorId, fullName, lastUpdate);
    }
}
