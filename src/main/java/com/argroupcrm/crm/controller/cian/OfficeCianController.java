package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.service.cian.OCianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeCianEntity> addCian(@RequestBody OfficeCianEntity officeCianEntity){
        log.info("addCian");
        try {
            return oCianService.create(officeCianEntity);
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
