package com.argroupcrm.crm.service.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.BuildingEntity;
import com.argroupcrm.crm.repository.oldtemplate.BuildingEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuildingServiceImpl implements BuildingService {
    private final BuildingEntityRepository buildingEntityRepository;
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_MODERATOR')")
    @Transactional(readOnly = true)
    public ResponseEntity<List<BuildingEntity>> getAll() {
        return ResponseEntity.ok(buildingEntityRepository.findAll());
    }

    @Override
    @Transactional
    public ResponseEntity<BuildingEntity> addBuilding(BuildingEntity buildingEntity) {
        try {
            return ResponseEntity.ok(buildingEntityRepository.save(buildingEntity));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<BuildingEntity> updateBuilding(Integer id,BuildingEntity buildingEntity) {
        try {
            buildingEntity.setId(id);
            return ResponseEntity.ok(buildingEntityRepository.save(buildingEntity));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteBuilding(Integer id) {
        try {
            buildingEntityRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
