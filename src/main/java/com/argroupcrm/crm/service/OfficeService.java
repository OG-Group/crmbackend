package com.argroupcrm.crm.service;

import com.argroupcrm.crm.model.OfficeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OfficeService {
    ResponseEntity<List<OfficeEntity>> getAll();

    ResponseEntity<OfficeEntity> addOffice(OfficeEntity officeEntity);

    ResponseEntity<OfficeEntity> updateOffice(Integer id,OfficeEntity officeEntity);

    ResponseEntity<?> deleteOffice(Integer id);
}
