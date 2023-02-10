package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.generic.crud.AbstractController;
import com.argroupcrm.crm.generic.crud.AbstractService;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.service.cian.BCianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<BuildingCianEntity> addCian(@RequestBody BuildingCianEntity buildingCianEntity){
        log.info("addCian building");
        try {
            return bCianService.create(buildingCianEntity);
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
    @Override
    public ResponseEntity<Page<BuildingCianEntity>> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Page<BuildingCianEntity>> getPageAndSort(int page, int size, String sort) {
        return null;
    }

    @Override
    public ResponseEntity<BuildingCianEntity> getOne(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BuildingCianEntity> update(BuildingCianEntity update) {
        return null;
    }

    @Override
    public ResponseEntity<BuildingCianEntity> create(BuildingCianEntity create) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
