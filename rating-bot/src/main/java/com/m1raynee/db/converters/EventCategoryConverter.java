package com.m1raynee.db.converters;

import com.m1raynee.db.enums.EventCategory;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EventCategoryConverter implements AttributeConverter<EventCategory, String> {
    @Override
    public String convertToDatabaseColumn(EventCategory category) {
        if (category == null)
            return null;

        return category.getCode();
    }

    @Override
    public EventCategory convertToEntityAttribute(String dbCode) {
        if (dbCode == null)
            return null;
        return EventCategory.fromCode(dbCode);
    }
}
