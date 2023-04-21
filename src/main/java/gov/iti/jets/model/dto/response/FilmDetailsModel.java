package gov.iti.jets.model.dto.response;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.BaseModel;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import gov.iti.jets.model.mapping.converter.FilmRatingConverter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.Convert;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.List;

/**
 * The film detail model provides a list of actors for each film.
 */
@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@JsonbPropertyOrder({"Film Id", "Film Titile", "Film Description", "Film Duration", "Film Rating"})
public class FilmDetailsModel extends BaseModel {
    public FilmDetailsModel(Integer filmId, String title, String description, Integer length, FilmRating rating) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.length = length;
        this.rating = rating;
    }

    @JsonbProperty("Film Id")
    private Integer filmId;

    @JsonbProperty("Film Title")
    private String title;

    @JsonbProperty("Film Description")
    private String description;

    @JsonbProperty("Film Category")
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @JsonbProperty("Film Duration")
    private Integer length;

    @JsonbProperty("Film Rating")
    @Convert(converter = FilmRatingConverter.class)
    private FilmRating rating;

    @JsonbProperty("Actor List")
    private List<ActorModel> actors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDetailsModel that = (FilmDetailsModel) o;
        return Objects.equal(filmId, that.filmId)
                && Objects.equal(title, that.title)
                && Objects.equal(description, that.description)
                && category == that.category
                && Objects.equal(length, that.length)
                && rating == that.rating
                && Objects.equal(actors, that.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, title, description, category, length, rating, actors);
    }
}
