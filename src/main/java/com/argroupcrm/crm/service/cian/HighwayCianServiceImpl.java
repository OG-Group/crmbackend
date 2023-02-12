package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.generic.dto.response.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.HighwayCianEntity;
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
public class HighwayCianServiceImpl implements HighwayCianService{
    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(HighwayCianEntity entity) {
        return null;
    }

    @Override
    @Transactional
    public HighwayCianEntity update(HighwayCianEntity entity) {
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public HighwayCianEntity findById(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<HighwayCianEntity> findAll(Pageable pageable) {
        return null;
    }
}
