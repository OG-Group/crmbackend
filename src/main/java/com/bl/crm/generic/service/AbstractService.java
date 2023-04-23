package com.example.crm.generic.service;

import com.example.crm.generic.dto.SearchRequestDTO;
import com.example.crm.generic.model.AbstractEntity;
import com.example.crm.web.dto.ResponseDTO;

public interface AbstractService<T extends AbstractEntity> {
    T save(T entity);

    T update(T entity);

    void delete(Long id);

    T findById(Long id);

    ResponseDTO<T> findAll(SearchRequestDTO searchRequestDTO);

}