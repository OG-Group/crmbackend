package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.dto.cian.OfficeCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.service.cian.OCianService;
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
@RequestMapping("/api/cian/office")
@RequiredArgsConstructor
@Slf4j
public class OfficeCianController {
    private final OCianService oCianService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<CreateResponseDTO> create(@RequestBody OfficeCianEntityDto officeCianEntity) {
        log.info("addCian");
        try {
            return oCianService.save(officeCianEntity);
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<OfficeCianEntity>> getPage(Pageable pageable) {
        try {
            log.info("getPage office");
            return ResponseEntity.ok(oCianService.findAll(pageable));
        } catch (Exception e) {
            log.error("getPage error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/sort")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<OfficeCianEntity>> getPageAndSort(@RequestParam int page, @RequestParam int size, @RequestParam String sort) {
        try {
            log.info("getPageAndSort office");
            return ResponseEntity.ok(oCianService.findAll(PageRequest.of(page, size, Sort.by(sort))));
        } catch (Exception e) {
            log.error("getPageAndSort error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeCianEntity> getOne(@PathVariable Long id) {
        try {
            log.info("getOne office");
            return ResponseEntity.ok(oCianService.findById(id));
        } catch (Exception e) {
            log.error("getOne error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeCianEntity> update(@RequestBody OfficeCianEntityDto update) {
        try {
            log.info("update office");
            return ResponseEntity.ok(oCianService.update(update));
        } catch (Exception e) {
            log.error("update error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public void delete(@PathVariable Long id) {
        try {
            log.info("delete office");
            oCianService.delete(id);
        } catch (Exception e) {
            log.error("delete error ", e);
        }
    }
}
