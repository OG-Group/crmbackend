package com.argroupcrm.crm.controller;

import com.argroupcrm.crm.model.BuildingEntity;
import com.argroupcrm.crm.service.BuildingService;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/building")
@RequiredArgsConstructor
@Slf4j
public class BuildingController {
    private final BuildingService buildingService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<List<BuildingEntity>> getAll(){
        log.info("getAll");
        return buildingService.getAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<BuildingEntity> addBuilding(@RequestBody BuildingEntity buildingEntity){
        log.info("addBuilding");
        return buildingService.addBuilding(buildingEntity);
    }
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<BuildingEntity> updateBuilding(@PathVariable Integer id,@RequestBody BuildingEntity buildingEntity){
        log.info("updateBuilding");
        return buildingService.updateBuilding(id,buildingEntity);
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<?> deleteBuilding(@PathVariable Integer id){
        log.info("deleteBuilding");
        return buildingService.deleteBuilding(id);
    }
}
