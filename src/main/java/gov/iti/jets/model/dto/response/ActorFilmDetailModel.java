package gov.iti.jets.model.dto.response;

import com.google.common.base.Objects;
import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.mapping.converter.FilmRatingConverter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ActorFilmDetailModel extends BaseModel {

    @JsonbProperty("Film ID")
    private Integer filmId;

    @Size(min = 1, max = 255)
    @JsonbProperty("Film Title")
    private String title;

    @Size(max = 65535)
    @JsonbProperty("Film Description")
    private String description;

    @JsonbProperty("Film Duration")
    private Integer length;

    @JsonbProperty("Film Rating")
    @Convert(converter = FilmRatingConverter.class)
    private FilmRating rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorFilmDetailModel that = (ActorFilmDetailModel) o;
        return Objects.equal(filmId, that.filmId)
                && Objects.equal(title, that.title)
                && Objects.equal(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, title, description);
    }
}
