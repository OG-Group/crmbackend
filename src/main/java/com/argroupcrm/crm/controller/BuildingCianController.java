package com.argroupcrm.crm.controller;

import com.argroupcrm.crm.model.BuildingCianEntity;
import com.argroupcrm.crm.service.BCianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/cian/building")
@RequiredArgsConstructor
@Slf4j
public class BuildingCianController {
    private final BCianService bCianService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<BuildingCianEntity> addCian(@RequestBody BuildingCianEntity buildingCianEntity){
        log.info("addCian building");
        try {
            return ResponseEntity.ok(bCianService.add(buildingCianEntity));
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
