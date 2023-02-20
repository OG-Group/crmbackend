package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.dto.cian.BuildingCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.service.cian.BCianService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/cian/building")
public class BuildingCianController {
    private final BCianService bCianService;

    @PostMapping
    @Operation(summary = "Обновить данные/ officeEntity должно быть пустым, лучше вообще удалить это поле")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<CreateResponseDTO> create(@RequestBody BuildingCianEntity buildingCianEntityDto) {
        log.info("addCian building");
        try {
            return bCianService.save(buildingCianEntityDto);
        } catch (Exception e) {
            log.error("addCian building error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<BuildingCianEntity>> getPage(Pageable pageable) {
        try {
            log.info("getPage building");
            return ResponseEntity.ok(bCianService.findAll(pageable));
        } catch (Exception e) {
            log.error("getPage error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/sort")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<BuildingCianEntity>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        try {
            log.info("getPageAndSort building");
            return ResponseEntity.ok(bCianService.findAll(PageRequest.of(page, size, Sort.by(sort))));
        } catch (Exception e) {
            log.error("getPageAndSort error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<BuildingCianEntity> getOne(@PathVariable Long id) {
        try {
            log.info("getOne building");
            return ResponseEntity.ok(bCianService.findById(id));
        } catch (Exception e) {
            log.error("getOne error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping
    public ResponseEntity<BuildingCianEntity> update(@RequestBody BuildingCianEntityDto update) {
        try {
            log.info("update building");
            return ResponseEntity.ok(bCianService.update(update));
        } catch (Exception e) {
            log.error("update error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        try {
            log.info("delete building");
            bCianService.delete(id);
        } catch (Exception e) {
            log.error("delete error ", e);
        }
    }
}
