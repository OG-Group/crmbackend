package com.argroupcrm.crm.generic.crud.controller;

import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.service.AbstractService;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
public abstract class AbstractControllerImpl<E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {
    private final AbstractService<E> service;
    @Override
    public ResponseEntity<Page<E>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @Override
    public ResponseEntity<E> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Override
    public ResponseEntity<Page<E>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort){
        return ResponseEntity.ok(service.findAll(PageRequest.of(page, size, Sort.by(sort))));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E update) {
        return ResponseEntity.ok(service.update(update));
    }

    @Override
    public ResponseEntity<CreateResponseDTO> create(@RequestBody E create) {
        return ResponseEntity.ok(service.save(create).getBody());
    }

    @Override
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}