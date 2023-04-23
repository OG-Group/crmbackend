package com.bl.crm.generic.service;

import com.bl.crm.web.dto.ResponseDTO;
import com.bl.crm.generic.dto.SearchRequestDTO;
import com.bl.crm.generic.model.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {
    T save(T entity);

    T update(T entity);

    void delete(Long id);

    T findById(Long id);

    ResponseDTO<T> findAll(SearchRequestDTO searchRequestDTO);

}