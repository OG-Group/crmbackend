package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.dto.cian.OfficeCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface OCianService {
    ResponseEntity<CreateResponseDTO> save(OfficeCianEntity officeCianEntity);

    OfficeCianEntity update(OfficeCianEntityDto officeCianEntity);

    void delete(Long id);

    OfficeCianEntity findById(Long id);

    Page<OfficeCianEntity> findAll(Pageable pageable);
}
