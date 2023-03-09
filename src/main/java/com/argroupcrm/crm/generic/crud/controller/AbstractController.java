package com.argroupcrm.crm.generic.crud.controller;

import com.argroupcrm.crm.generic.crud.dto.AbstractResponseDTO;
import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import com.argroupcrm.crm.generic.crud.model.specification.request.SearchRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


public interface AbstractController<T extends AbstractEntity> {
    @Operation(summary = "Получить постранично", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    ResponseEntity<AbstractResponseDTO<T>> getPage(Pageable pageable);

    @Operation(summary = "Поиск по фильтрам", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("filter")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    ResponseEntity<AbstractResponseDTO<T>> searchFilter(@RequestBody SearchRequest request);

    @Operation(summary = "Получить по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    ResponseEntity<T> getOne(@PathVariable Long id);

    @Operation(summary = "Обновить данные", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    ResponseEntity<T> update(@RequestBody T update);

    @Operation(summary = "Создать сущность", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    ResponseEntity<T> create(@RequestBody T create);

    @Operation(summary = "Удалить сущность по id", security = @SecurityRequirement(name = "bearerAuth"))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    void delete(@PathVariable Long id);
}
