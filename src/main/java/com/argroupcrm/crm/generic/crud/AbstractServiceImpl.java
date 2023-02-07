package com.argroupcrm.crm.generic.crud;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class AbstractServiceImpl<T extends AbstractEntity, R extends AbstractRepository<T>>
        implements AbstractService<T> {

    private final R repository;
    private final ModelMapper patchingMapper;

    @Override
    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        T entityFromBd = repository.findById(entity.getId()).orElseThrow();
        patchingMapper.map(entity, entityFromBd);
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
