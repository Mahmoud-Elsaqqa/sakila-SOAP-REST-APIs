package gov.iti.jets.model.dto.extra;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.dto.BaseDto;
import gov.iti.jets.model.mapping.converter.CategoryConverter;
import gov.iti.jets.model.mapping.converter.FilmRatingConverter;
import jakarta.persistence.Convert;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

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
public class FilmDetailsModel extends BaseDto {
    /**
     * film id
     */
    private Integer filmId;

    /**
     * film title
     */
    private String title;

    /**
     * film description
     */
    private String description;

    /**
     * category name
     */
    @Convert(converter = CategoryConverter.class)
    private Category category;

    /**
     * rental price
     */
    private BigDecimal price;

    /**
     * film length
     */
    private Integer length;

    /**
     * film rating
     */
    @Convert(converter = FilmRatingConverter.class)
    private FilmRating rating;

    /**
     * film actors
     */
    private String actors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDetailsModel that = (FilmDetailsModel) o;
        return Objects.equal(filmId, that.filmId)
                && Objects.equal(title, that.title)
                && Objects.equal(description, that.description)
                && category == that.category
                && Objects.equal(price, that.price)
                && Objects.equal(length, that.length)
                && rating == that.rating
                && Objects.equal(actors, that.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, title, description, category, price, length, rating, actors);
    }
}
