package gov.iti.jets.model.mapping.converter;

import gov.iti.jets.model.constant.SpecialFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

@Converter
public class SpecialFeatureConverter implements AttributeConverter<EnumSet<SpecialFeature>, String> {
    @Override
    public String convertToDatabaseColumn(EnumSet<SpecialFeature> attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.stream()
                .map(SpecialFeature::getFeature)
                .collect(Collectors.joining(","));
    }

    @Override
    public EnumSet<SpecialFeature> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Arrays.stream(dbData.split(","))
                .map(featureString -> Arrays.stream(SpecialFeature.values())
                        .filter(feature -> feature.getFeature().equals(featureString))
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(SpecialFeature.class)));
    }
}
