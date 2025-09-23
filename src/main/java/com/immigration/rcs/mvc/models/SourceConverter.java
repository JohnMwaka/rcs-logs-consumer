package com.immigration.rcs.mvc.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class SourceConverter implements AttributeConverter<Enumerations.Source, String> {

    @Override
    public String convertToDatabaseColumn(Enumerations.Source attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public Enumerations.Source convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Enumerations.Source.valueOf(dbData);
    }
}
