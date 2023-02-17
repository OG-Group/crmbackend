package com.argroupcrm.crm.generic.crud.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ogbozoyan
 * @date 12.02.2023
 */
@Data
@NoArgsConstructor
public class CreateResponseDTO{
    private Long id;
    private String message;

    public CreateResponseDTO(Long id, String message) {
        this.id = id;
        this.message = message;
    }

}
