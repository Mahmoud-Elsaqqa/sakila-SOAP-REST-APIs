package gov.iti.jets.model.dto.inventory;


import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.FullName;
import jakarta.json.bind.annotation.JsonbProperty;
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
public class ActorModel extends BaseModel {


    @JsonbProperty("Actor Id")
    private Integer id;

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
        return Objects.equal(id, that.id)
                && Objects.equal(fullName, that.fullName)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, fullName, lastUpdate);
    }
}
