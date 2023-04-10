package gov.iti.jets.model.dto.extra;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseDto;
import lombok.*;
import lombok.experimental.FieldNameConstants;

/**
 * The actor detail model provides a list of films in which actors appear by category.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActorDetailsModel extends BaseDto {
    /**
     * actor id
     */
    private Integer actorId;

    /**
     * actor first name
     */
    private String firstName;

    /**
     * actor last name
     */
    private String lastName;

    /**
     * a list of films in which the actor appears by category
     */
    private String filmInfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDetailsModel that = (ActorDetailsModel) o;
        return Objects.equal(actorId, that.actorId)
                && Objects.equal(firstName, that.firstName)
                && Objects.equal(lastName, that.lastName)
                && Objects.equal(filmInfo, that.filmInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(actorId, firstName, lastName, filmInfo);
    }
}
