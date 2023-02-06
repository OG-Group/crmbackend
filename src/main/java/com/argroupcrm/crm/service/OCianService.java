package com.argroupcrm.crm.service;

import com.argroupcrm.crm.model.OfficeCianEntity;
import org.springframework.http.ResponseEntity;

public interface OCianService {
    ResponseEntity<OfficeCianEntity> add(OfficeCianEntity officeCianEntity);
}
