package com.argroupcrm.crm.controller.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.OfficeEntity;
import com.argroupcrm.crm.service.oldtemplate.OfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/office")
@RequiredArgsConstructor
@Slf4j
public class OfficeController {
    private final OfficeService officeService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<List<OfficeEntity>> getAll(){
        log.info("getAll");
        return officeService.getAll();
    }
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeEntity> addOffice(@RequestBody OfficeEntity officeEntity){
        log.info("addOffice");
        return officeService.addOffice(officeEntity);
    }
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<OfficeEntity> updateOffice(@PathVariable Integer id,@RequestBody OfficeEntity officeEntity){
        log.info("updateOffice");
        return officeService.updateOffice(id,officeEntity);
    }
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER','ROLE_MODERATOR')")
    public ResponseEntity<?> deleteOffice(@PathVariable Integer id){
        log.info("deleteOffice");
        return officeService.deleteOffice(id);
    }
}*/
