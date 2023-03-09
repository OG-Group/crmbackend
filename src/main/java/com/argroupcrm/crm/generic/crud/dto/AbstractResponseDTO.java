package com.argroupcrm.crm.generic.crud.dto;

import lombok.Data;

import java.util.List;

/**
 * @author ogbozoyan
 * @date 13.02.2023
 */

@Data
public class AbstractResponseDTO<E> {
    private List<E> content;
    private Long totalElements;
    private Integer totalPages;

    public AbstractResponseDTO(List<E> content, Long totalElements, Integer totalPages) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
}
