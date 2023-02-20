package com.argroupcrm.crm.generic.crud.controller;

import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.generic.crud.model.AbstractEntity;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AbstractController<T extends AbstractEntity> {

    @Operation(summary = "Получить постранично")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<Page<T>> getPage(Pageable pageable);

    @Operation(summary = "Получить постранично с сортировкой по полю")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sort")
    ResponseEntity<Page<T>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort);

    @Operation(summary = "Получить по id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    ResponseEntity<?> getOne(@PathVariable Long id);

    @Operation(summary = "Обновить данные")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    ResponseEntity<?> update(@RequestBody T update);

    @Operation(summary = "Создать сущность")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    ResponseEntity<CreateResponseDTO> create(@RequestBody T create);

    @Operation(summary = "Удалить сущность по id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
