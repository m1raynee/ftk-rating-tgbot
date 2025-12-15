package com.m1raynee.db.converters;

import com.m1raynee.db.enums.RatingEntryType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingEntryTypeConverter implements AttributeConverter<RatingEntryType, String> {
    @Override
    public String convertToDatabaseColumn(RatingEntryType type) {
        if (type == null)
            return null;

        return type.getCode();
    }

    @Override
    public RatingEntryType convertToEntityAttribute(String dbCode) {
        if (dbCode == null)
            return null;
        return RatingEntryType.fromCode(dbCode);
    }

}
