package com.argroupcrm.crm.generic.crud.service;

import com.argroupcrm.crm.controller.advice.*;
import com.argroupcrm.crm.generic.crud.dto.AbstractResponseDTO;
import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.model.specification.SearchSpecification;
import com.argroupcrm.crm.generic.crud.model.specification.request.SearchRequest;
import com.argroupcrm.crm.generic.crud.repository.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;

import static com.argroupcrm.crm.generic.crud.util.Reflection.getClassGeneric;

@RequiredArgsConstructor
public abstract class AbstractServiceImpl<T extends AbstractEntity, R extends AbstractRepository<T>> implements AbstractService<T> {
    private final R repository;

    @Autowired
    private ModelMapper patchingMapper;

    @Override
    @Transactional
    public T save(T entity) {
        try {
            return repository.save(entity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        } catch (OptimisticLockingFailureException e) {
            e.printStackTrace();
            throw new OptimisticLockingFailureException("OptimisticLockingFailureException exception on save: " + entity);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new DataIntegrityViolationException("DataIntegrityViolationException exception on save: " + entity);
        } catch (TransactionSystemException e) {
            e.printStackTrace();
            throw new TransactionSystemException("TransactionSystemException exception on save: " + entity);
        } catch (JpaSystemException e) {
            e.printStackTrace();
            throw new JpaSystemException(e);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException("PersistenceException exception on save: " + entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SaveException("Can't save entity: " + entity);
        }
    }

    @Override
    @Transactional
    public T update(T entity) {

        T entityFromBd = repository.findById(entity.getId()).orElseThrow();
        patchingMapper.map(entity, entityFromBd);
        try {
            return repository.saveAndFlush(entity);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("DataAccessException exception update: " + entity);
        } catch (OptimisticLockException e) {
            e.printStackTrace();
            throw new OptimisticLockException("OptimisticLockException exception on update: " + entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException("PersistenceException exception on update: " + entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UpdateException("Can't update entity: " + entity);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            T entity = repository.findById(id)
                    .orElseThrow(() -> new DeleteNotFoundException("Entity not found with id: " + id));
            repository.delete(entity);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("EmptyResultDataAccessException exception deleteById:" + id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("DataAccessException exception deleteById: " + id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DeleteException("Can't delete with id: " + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new FindException("Entity not found with id " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public AbstractResponseDTO<T> findAll(Pageable pageable) {
        try {
            Page<T> page = repository.findAll(pageable);
            if (page.isEmpty()) {
                throw new PageNotFoundException("No entities found");
            }
            return new AbstractResponseDTO<>(page.getContent(), page.getTotalElements(), page.getTotalPages());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("EmptyResultDataAccessException exception findAll: " + pageable);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("DataAccessException exception findAll: " + pageable);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("IllegalArgumentException exception findAll: " + pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PageException("Page Exception: " + pageable);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AbstractResponseDTO<T> searchFilter(SearchRequest request) {
        try {
            Class<?> clas = getClassGeneric(this);
            request = request.validateFilterType(clas, request);
            SearchSpecification<T> specification = new SearchSpecification<>(request);
            Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
            Page<T> page = repository.findAll(specification, pageable);
            if (page.isEmpty()) {
                throw new PageNotFoundException("No entities found");
            }
            return new AbstractResponseDTO<>(page.getContent(), page.getTotalElements(), page.getTotalPages());
        } catch (InvalidDataAccessApiUsageException e) {
            e.printStackTrace();
            throw new InvalidDataAccessApiUsageException("InvalidDataAccessApiUsageException exception searchFilter: " + request);
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("DataAccessException exception searchFilter: " + request);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("IllegalArgumentException exception searchFilter: " + request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FilterException("Filter exception: "+request);
        }
    }
}
