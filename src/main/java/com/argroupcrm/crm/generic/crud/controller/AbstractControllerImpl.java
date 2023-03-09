package com.argroupcrm.crm.generic.crud.controller;

import com.argroupcrm.crm.generic.crud.dto.AbstractResponseDTO;
import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.model.specification.request.SearchRequest;
import com.argroupcrm.crm.generic.crud.service.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public abstract class AbstractControllerImpl<E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {
    private final AbstractService<E> service;

    @Override
    public ResponseEntity<AbstractResponseDTO<E>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @Override
    public ResponseEntity<E> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Override
    public ResponseEntity<AbstractResponseDTO<E>> searchFilter(@RequestBody SearchRequest request){
        return ResponseEntity.ok(service.searchFilter(request));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E update) {
        return ResponseEntity.ok(service.update(update));
    }

    @Override
    public ResponseEntity<E> create(@RequestBody E create) {
        return ResponseEntity.ok(service.save(create));
    }

    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}