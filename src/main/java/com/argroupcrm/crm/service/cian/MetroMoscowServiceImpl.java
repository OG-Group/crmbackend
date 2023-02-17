package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.MetroMoscowEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetroMoscowServiceImpl implements MetroMoscowService{
    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(MetroMoscowEntity entity) {
        return null;
    }

    @Override
    @Transactional
    public MetroMoscowEntity update(MetroMoscowEntity entity) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public MetroMoscowEntity findById(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MetroMoscowEntity> findAll(Pageable pageable) {
        return null;
    }
}
