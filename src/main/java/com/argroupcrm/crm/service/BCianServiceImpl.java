package com.argroupcrm.crm.service;

import com.argroupcrm.crm.model.BuildingCianEntity;
import com.argroupcrm.crm.repository.BuildingCianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BCianServiceImpl implements BCianService {
    private final BuildingCianRepository buildingCianRepository;


    @Override
    public BuildingCianEntity add(BuildingCianEntity buildingCianEntity) {
        try {
            return buildingCianRepository.save(buildingCianEntity);
        } catch (Exception e) {
            log.error("addCian error ", e);
            return null;
        }
    }
}
