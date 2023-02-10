package com.argroupcrm.crm.generic.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
public abstract class AbstractControllerImpl<E extends AbstractEntity, S extends AbstractService<E>>
        implements AbstractController<E> {
    private final AbstractService<E> service;
    static final String EnumRoles = "ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR";
    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public ResponseEntity<Page<E>> getPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public ResponseEntity<E> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public ResponseEntity<Page<E>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort){
        return ResponseEntity.ok(service.findAll(PageRequest.of(page, size, Sort.by(sort))));
    }

    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public ResponseEntity<E> update(@RequestBody E update) {
        return ResponseEntity.ok(service.update(update));
    }

    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public ResponseEntity<E> create(@RequestBody E create) {
        return ResponseEntity.ok(service.save(create));
    }

    @Override
    @PreAuthorize("hasAnyRole(EnumRoles)")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}