package gov.iti.jets.model.mapping.converter;


import gov.iti.jets.model.constant.Language;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class LanguageConverter implements AttributeConverter<Language, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Language attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        return attribute.getId();
    }

    @Override
    public Language convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return Language.NONE;
        } else {
            return Language.getLanguageById(dbData);
        }
    }
}
