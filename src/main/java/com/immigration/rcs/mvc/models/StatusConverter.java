package com.immigration.rcs.mvc.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class StatusConverter implements AttributeConverter<Enumerations.Status, String> {

    @Override
    public String convertToDatabaseColumn(Enumerations.Status attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public Enumerations.Status convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Enumerations.Status.valueOf(dbData);
    }
}
