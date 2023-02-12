package com.argroupcrm.crm.generic.dto.response;

import lombok.Data;

/**
 * @author ogbozoyan
 * @date 12.02.2023
 */
@Data
public class UpdateResponseDTO  {
    private Long id;
    private String message;
    public UpdateResponseDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
