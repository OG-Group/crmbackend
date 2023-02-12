package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.generic.crud.AbstractController;
import com.argroupcrm.crm.generic.dto.response.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.service.cian.BCianService;
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
public class BuildingCianController implements AbstractController<BuildingCianEntity> {
    private final BCianService bCianService;
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<CreateResponseDTO> create(@RequestBody BuildingCianEntity create) {
        try {
            log.info("create building");
            return bCianService.save(create);
        } catch (Exception e) {
            log.error("create error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<BuildingCianEntity>> getPage(@RequestBody Pageable pageable) {
        try {
            log.info("getPage building");
            return ResponseEntity.ok(bCianService.findAll(pageable));
        } catch (Exception e) {
            log.error("getPage error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<BuildingCianEntity>> getPageAndSort(@RequestParam int page,@RequestParam int size,@RequestParam String sort) {
        try {
            log.info("getPageAndSort building");
            return ResponseEntity.ok(bCianService.findAll(PageRequest.of(page, size, Sort.by(sort))));
        } catch (Exception e) {
            log.error("getPageAndSort error ", e);
            return ResponseEntity.badRequest().build();
        }
    }


    @Override
    public ResponseEntity<BuildingCianEntity> getOne(@RequestParam Long id) {
        try{
            log.info("getOne building");
            return ResponseEntity.ok(bCianService.findById(id));
        } catch (Exception e) {
            log.error("getOne error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<BuildingCianEntity> update(@RequestBody BuildingCianEntity update) {
        try {
            log.info("update building");
            return ResponseEntity.ok(bCianService.update(update));
        } catch (Exception e) {
            log.error("update error ", e);
            return ResponseEntity.badRequest().build();
        }
    }


    @Override
    public void delete(Long id) {
        try {
            log.info("delete building");
            bCianService.delete(id);
        } catch (Exception e) {
            log.error("delete error ", e);
        }
    }
}
