package com.argroupcrm.crm.generic.crud;

import com.argroupcrm.crm.generic.dto.response.CreateResponseDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AbstractController<T extends  AbstractEntity>{

    @ApiOperation(value = "Получить постранично")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<Page<T>> getPage(@RequestBody Pageable pageable);
    @ApiOperation(value = "Получить постранично с сортировкой по полю")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/sort")
    ResponseEntity<Page<T>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort);
    @ApiOperation(value = "Получить по id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    ResponseEntity<?> getOne(@PathVariable Long id);
    @ApiOperation(value = "Обновить данные")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    ResponseEntity<?> update(@RequestBody T update);
    @ApiOperation(value = "Создать сущность")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    ResponseEntity<CreateResponseDTO> create(@RequestBody T create);
    @ApiOperation(value = "Удалить сущность по id")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
