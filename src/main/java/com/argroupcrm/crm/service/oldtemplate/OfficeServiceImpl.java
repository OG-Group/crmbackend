package com.argroupcrm.crm.service.oldtemplate;

import com.argroupcrm.crm.model.oldtemplate.OfficeEntity;
import com.argroupcrm.crm.repository.oldtemplate.OfficeEntityRepository;
import com.argroupcrm.crm.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
@Service
@RequiredArgsConstructor
@Slf4j
public class OfficeServiceImpl implements OfficeService{
    private final OfficeEntityRepository officeEntityRepository;
    private final BuildingService buildingService;
    private final UserService userService;
    private final MetroService metroService;
    private final HighwayService highwayService;
    private final PhotoService photoService;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<OfficeEntity>> getAll() {
        return ResponseEntity.ok(officeEntityRepository.findAll());
    }

    @Override
    @Transactional
    public ResponseEntity<OfficeEntity> addOffice(OfficeEntity officeEntity) {
        try{
            return ResponseEntity.ok(officeEntityRepository.save(officeEntity));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<OfficeEntity> updateOffice(Integer id,OfficeEntity officeEntity) {
        try{
            officeEntity.setId(id);
            return ResponseEntity.ok(officeEntityRepository.save(officeEntity));
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteOffice(Integer id) {
        try {
            officeEntityRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
*/