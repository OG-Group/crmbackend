package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import org.springframework.http.ResponseEntity;

public interface BCianService {
    ResponseEntity<BuildingCianEntity> create(BuildingCianEntity buildingCianEntity);
}
