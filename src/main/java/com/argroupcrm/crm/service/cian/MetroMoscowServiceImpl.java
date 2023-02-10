package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.model.cian.MetroMoscowEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetroMoscowServiceImpl implements MetroMoscowService{
    @Override
    public MetroMoscowEntity save(MetroMoscowEntity entity) {
        return null;
    }

    @Override
    public MetroMoscowEntity update(MetroMoscowEntity entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public MetroMoscowEntity findById(Long id) {
        return null;
    }

    @Override
    public Page<MetroMoscowEntity> findAll(Pageable pageable) {
        return null;
    }
}
