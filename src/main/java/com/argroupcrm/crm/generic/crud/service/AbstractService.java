package com.argroupcrm.crm.generic.crud.service;

import com.argroupcrm.crm.generic.crud.dto.AbstractResponseDTO;
import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.model.specification.request.SearchRequest;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T extends AbstractEntity> {
    T save(T entity);

    T update(T entity);

    void delete(Long id);

    T findById(Long id);

    AbstractResponseDTO<T> findAll(Pageable pageable);

    AbstractResponseDTO<T> searchFilter(SearchRequest request);
}