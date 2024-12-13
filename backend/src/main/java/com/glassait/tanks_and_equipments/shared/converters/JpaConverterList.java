package com.glassait.tanks_and_equipments.shared.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.List;

@Converter(autoApply = true)
public class JpaConverterList implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> meta) {
        return meta.toString();
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return List.of(dbData.split(","));
    }
}
