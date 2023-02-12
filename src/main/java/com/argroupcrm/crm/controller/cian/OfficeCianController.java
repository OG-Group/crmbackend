package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.generic.crud.AbstractController;
import com.argroupcrm.crm.generic.dto.response.CreateResponseDTO;
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
public class OfficeCianController implements AbstractController<OfficeCianEntity> {
    private final OCianService oCianService;

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<CreateResponseDTO> create(@RequestBody OfficeCianEntity officeCianEntity) {
        log.info("addCian");
        try {
            return oCianService.save(officeCianEntity);
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }


    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<OfficeCianEntity>> getPage(@RequestBody Pageable pageable) {
        try {
            log.info("getPage office");
            return ResponseEntity.ok(oCianService.findAll(pageable));
        } catch (Exception e) {
            log.error("getPage error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<Page<OfficeCianEntity>> getPageAndSort(@RequestParam int page,@RequestParam int size,@RequestParam String sort) {
        try {
            log.info("getPageAndSort office");
            return ResponseEntity.ok(oCianService.findAll(PageRequest.of(page, size, Sort.by(sort))));
        } catch (Exception e) {
            log.error("getPageAndSort error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeCianEntity> getOne(@RequestParam Long id) {
        try{
            log.info("getOne office");
            return ResponseEntity.ok(oCianService.findById(id));
        }
        catch (Exception e) {
            log.error("getOne error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeCianEntity> update(@RequestBody OfficeCianEntity update) {
        try {
            log.info("update office");
            return ResponseEntity.ok(oCianService.update(update));
        } catch (Exception e) {
            log.error("update error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public void delete(@RequestParam Long id) {
        try {
            log.info("delete office");
            oCianService.delete(id);
        } catch (Exception e) {
            log.error("delete error ", e);
        }
    }
}
