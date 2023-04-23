package com.example.crm.generic.dto;

import com.example.crm.generic.dto.enums.FieldType;
import com.example.crm.generic.dto.enums.Operator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class contains fields of request filter representation
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequestDTO {
    private String key;

    private Operator operator;

    private FieldType fieldType;

    private Object value;

    private Object valueTo;

    private List<Object> values;
}
