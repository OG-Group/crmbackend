package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.dto.cian.BuildingCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BCianService {
    ResponseEntity<CreateResponseDTO> save(BuildingCianEntity buildingCianEntity);

    BuildingCianEntity update(BuildingCianEntityDto entity);

    void delete(Long id);

    BuildingCianEntity findById(Long id);

    Page<BuildingCianEntity> findAll(Pageable pageable);
}
