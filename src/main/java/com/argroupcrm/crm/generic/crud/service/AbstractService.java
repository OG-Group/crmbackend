package com.argroupcrm.crm.generic.crud.service;

import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AbstractService<T extends AbstractEntity>  {
    ResponseEntity<CreateResponseDTO> save(T entity);
//какое-то количество нужных нам методов
    T update(T entity);
    void delete(Long id);
    T findById(Long id);
    Page<T> findAll(Pageable pageable);

}