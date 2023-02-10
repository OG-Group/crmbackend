package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.repository.cian.OfficeCianRepository;
import com.argroupcrm.crm.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class OCianServiceImpl implements OCianService{
    private final OfficeCianRepository officeCianRepository;
    private final UserService userService;
    @Override
    @Transactional
    public ResponseEntity<OfficeCianEntity> create(OfficeCianEntity officeCianEntity) {
        log.info("createCianOffice");
        try {
            if(officeCianRepository.existsById(officeCianEntity.getId())){
                return ResponseEntity.status(409).build();
            }
//            officeCianEntity.setCreateDate(Timestamp.valueOf(java.time.LocalDateTime.now()));
//            officeCianEntity.setUpdateDate(Timestamp.valueOf(java.time.LocalDateTime.now()));
//            officeCianEntity.setUpdatedBy(userService.getCurrent().getLogin());
//            officeCianEntity.setCreatedBy(userService.getCurrent().getLogin());
            return ResponseEntity.ok(officeCianRepository.save(officeCianEntity));
        } catch (Exception e) {
            log.error("addCian error ", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public OfficeCianEntity save(OfficeCianEntity entity) {
        return create(entity).getBody();
    }

    @Override
    public OfficeCianEntity update(OfficeCianEntity entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public OfficeCianEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<OfficeCianEntity> findAll(Pageable pageable) {
        return null;
    }
}
