package com.argroupcrm.crm.generic.crud;

import com.argroupcrm.crm.generic.dto.response.CreateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public abstract class AbstractServiceImpl<T extends AbstractEntity, R extends AbstractRepository<T>>
        implements AbstractService<T> {
    private final R repository;
    private final ModelMapper patchingMapper;

    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(T entity) {
        try {
            return ResponseEntity.ok(new CreateResponseDTO(repository.save(entity).getId(),"success"));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public T update(T entity) {
        try {
            T entityFromBd = repository.findById(entity.getId()).orElseThrow();
            patchingMapper.map(entity, entityFromBd);
            return repository.saveAndFlush(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        try {
            return repository.findAll(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
