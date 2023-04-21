package gov.iti.jets.model.dto.response;

import com.google.common.base.Objects;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.List;

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
@XmlRootElement
@JsonbPropertyOrder({"Actor Id", "First Name", "Last Name", "List of Films"})
public class ActorDetailsModel extends BaseModel {

    public ActorDetailsModel(Integer actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonbProperty("Actor Id")
    private Integer actorId;

    @JsonbProperty("First Name")
    private String firstName;

    @JsonbProperty("Last Name")
    private String lastName;

    @JsonbProperty("List of Films")
    private List<FilmModel> filmInfo;


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
