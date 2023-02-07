package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.repository.cian.BuildingCianRepository;
import com.argroupcrm.crm.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Slf4j
@RequiredArgsConstructor
public class BCianServiceImpl implements BCianService {
    private final BuildingCianRepository buildingCianRepository;
    private final UserService userService;


    @Override
    public ResponseEntity<BuildingCianEntity> create(BuildingCianEntity buildingCianEntity) {
        try {
            if(buildingCianRepository.existsById(buildingCianEntity.getId())){
                return ResponseEntity.status(409).build();
            }
            buildingCianEntity.setCreateDate(Timestamp.valueOf(java.time.LocalDateTime.now()));
            buildingCianEntity.setUpdateDate(Timestamp.valueOf(java.time.LocalDateTime.now()));
            buildingCianEntity.setUpdatedBy(userService.getCurrent().getLogin());
            buildingCianEntity.setCreatedBy(userService.getCurrent().getLogin());
            return ResponseEntity.ok(buildingCianRepository.save(buildingCianEntity));
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
