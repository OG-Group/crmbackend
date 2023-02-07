package com.argroupcrm.crm.generic.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractService<T extends AbstractEntity>  {
    T save(T entity);
//какое-то количество нужных нам методов
    T update(T entity);
    void delete(Long id);
    T findById(Long id);
    Page<T> findAll(Pageable pageable);

}