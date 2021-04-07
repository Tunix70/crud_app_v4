package com.tunix70.crudv4.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;

@Converter
public class TimeStampToLongConverter implements AttributeConverter<Long, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(Long meta) {
        return Timestamp.from(Instant.ofEpochMilli(meta));
    }

    @Override
    public Long convertToEntityAttribute(Timestamp dbData) {
        return dbData.getTime();
    }
}