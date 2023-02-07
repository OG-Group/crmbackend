package com.argroupcrm.crm.generic.crud;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AbstractController<T extends  AbstractEntity>{
    @GetMapping("getPage")
    ResponseEntity<Page<T>> getPage(Pageable pageable);
    @GetMapping("/{id}")
    ResponseEntity<T> getOne(@PathVariable Long id);
    @PatchMapping("update")
    ResponseEntity<T> update(@RequestBody T update);
    @PostMapping("create")
    ResponseEntity<T> create(@RequestBody T create);
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
