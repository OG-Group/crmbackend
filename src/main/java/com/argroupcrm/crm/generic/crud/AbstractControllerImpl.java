package com.argroupcrm.crm.generic.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class AbstractControllerImpl
        <E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {
    private final AbstractService<E> service;

    @Override
    @GetMapping("/getPage")
    public ResponseEntity<Page<E>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PatchMapping("/update")
    public ResponseEntity<E> update(@RequestBody E update) {
        return ResponseEntity.ok(service.update(update));
    }

    @PostMapping("/create")
    public ResponseEntity<E> create(@RequestBody E create) {
        return ResponseEntity.ok(service.save(create));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}