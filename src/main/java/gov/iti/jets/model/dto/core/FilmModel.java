package gov.iti.jets.model.dto.core;


import com.google.common.base.Objects;
import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.constant.Language;
import gov.iti.jets.model.constant.SpecialFeature;
import gov.iti.jets.model.mapping.converter.FilmRatingConverter;
import gov.iti.jets.model.mapping.converter.SpecialFeatureConverter;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumSet;

@Getter
@Setter
@ToString
@FieldNameConstants
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmModel {
    private Integer filmId;

    @Size(min = 1, max = 128)
    private String title;

    @Size(max = 65535)
    private String description;

    private LocalDate releaseYear;

    private Language languageId;

    private Language originalLanguageId;

    private Integer rentalDuration;

    private BigDecimal rentalRate;

    private Integer length;

    private BigDecimal replacementCost;

    @Convert(converter = FilmRatingConverter.class)
    private FilmRating rating;

    @Convert(converter = SpecialFeatureConverter.class)
    private EnumSet<SpecialFeature> specialFeatures;

    private LocalDateTime lastUpdate;

    @ToString.Exclude
    private LanguageModel languageByLanguageId;

    @ToString.Exclude
    private LanguageModel languageByOriginalLanguageId;

    @ToString.Exclude
    @JsonbTransient
    private Collection<FilmActorModel> filmActorsByFilmId;

    @ToString.Exclude
    private Collection<FilmCategoryModel> filmCategoriesByFilmId;

    @ToString.Exclude
    private Collection<InventoryModel> inventoriesByFilmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmModel that = (FilmModel) o;
        return Objects.equal(filmId, that.filmId)
                && Objects.equal(title, that.title)
                && Objects.equal(description, that.description)
                && Objects.equal(releaseYear, that.releaseYear)
                && languageId == that.languageId
                && originalLanguageId == that.originalLanguageId
                && Objects.equal(rentalDuration, that.rentalDuration)
                && Objects.equal(rentalRate, that.rentalRate)
                && Objects.equal(length, that.length)
                && Objects.equal(replacementCost, that.replacementCost)
                && rating == that.rating
                && Objects.equal(specialFeatures, that.specialFeatures)
                && Objects.equal(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(filmId, title, description, releaseYear,
                languageId, originalLanguageId, rentalDuration, rentalRate, length,
                replacementCost, rating, specialFeatures, lastUpdate);
    }
}
