package com.bl.crm.generic.dto;

import com.bl.crm.generic.dto.enums.SortDirection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class contains fields of request sort representation
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SortRequestDTO {
    private String key;

    private SortDirection direction;
}
