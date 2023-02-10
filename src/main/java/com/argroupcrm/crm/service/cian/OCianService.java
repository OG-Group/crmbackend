package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.generic.crud.AbstractService;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import org.springframework.http.ResponseEntity;

public interface OCianService extends AbstractService<OfficeCianEntity> {
    ResponseEntity<OfficeCianEntity> create(OfficeCianEntity officeCianEntity);
}
