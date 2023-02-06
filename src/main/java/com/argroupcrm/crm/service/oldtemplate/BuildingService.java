package com.argroupcrm.crm.service.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.BuildingEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BuildingService {
    ResponseEntity<List<BuildingEntity>> getAll();

    ResponseEntity<BuildingEntity> addBuilding(BuildingEntity buildingEntity);

    ResponseEntity<BuildingEntity> updateBuilding(Integer id,BuildingEntity buildingEntity);

    ResponseEntity<?> deleteBuilding(Integer id);
}
