package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import org.springframework.http.ResponseEntity;

public interface OCianService {
    ResponseEntity<OfficeCianEntity> create(OfficeCianEntity officeCianEntity);
}
