package com.argroupcrm.crm.model.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

/**
 * @author ogbozoyan
 * @date 12.02.2023
 */
@Data
@Converter
public class JpaConverterJson implements AttributeConverter<Object, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object meta) {
        try {
            if (meta == null) {
                return null;
            }
            return objectMapper.writeValueAsString(meta);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) {
                return null;
            }
            return objectMapper.readValue(dbData, Object.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}