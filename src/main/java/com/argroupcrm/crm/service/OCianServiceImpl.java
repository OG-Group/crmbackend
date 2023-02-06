package com.argroupcrm.crm.service;

import com.argroupcrm.crm.model.OfficeCianEntity;
import com.argroupcrm.crm.repository.OfficeCianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OCianServiceImpl implements OCianService{
    private final OfficeCianRepository officeCianRepository;
    @Override
    @Transactional
    public ResponseEntity<OfficeCianEntity> add(OfficeCianEntity officeCianEntity) {
        try {
            return ResponseEntity.ok(officeCianRepository.save(officeCianEntity));
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
