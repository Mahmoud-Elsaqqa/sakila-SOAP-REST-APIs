package gov.iti.jets.model.mapping.converter;

import gov.iti.jets.model.constant.FilmRating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FilmRatingConverter implements AttributeConverter<FilmRating, String> {
    @Override
    public String convertToDatabaseColumn(FilmRating attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        return attribute.getRating();
    }

    @Override
    public FilmRating convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            throw new IllegalArgumentException();
        }
        return FilmRating.getFilmRatingById(dbData);
    }
}
