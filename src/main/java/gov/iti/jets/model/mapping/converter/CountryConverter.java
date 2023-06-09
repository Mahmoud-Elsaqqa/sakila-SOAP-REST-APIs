package gov.iti.jets.model.mapping.converter;

import gov.iti.jets.model.constant.Country;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CountryConverter implements AttributeConverter<Country, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Country attribute) {
        if (attribute == null) {
            throw new IllegalArgumentException();
        }
        return attribute.getId();
    }

    @Override
    public Country convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            throw new IllegalArgumentException();
        }
        return Country.getCountryById(dbData);
    }
}
