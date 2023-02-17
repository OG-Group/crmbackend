package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.controller.advice.DeleteException;
import com.argroupcrm.crm.controller.advice.FindException;
import com.argroupcrm.crm.controller.advice.SaveException;
import com.argroupcrm.crm.controller.advice.UpdateException;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.repository.cian.BuildingCianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BCianServiceImpl implements BCianService {
    private final BuildingCianRepository buildingCianRepository;
    private final ModelMapper patchingMapper;

    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(BuildingCianEntity buildingCianEntity) {
        try {
            if(buildingCianRepository.existsById(buildingCianEntity.getId())){
                return ResponseEntity.status(409).build();
            }
            return ResponseEntity.ok(new CreateResponseDTO(buildingCianRepository.save(buildingCianEntity).getId(), "success"));
        } catch (Exception e) {
            throw new SaveException("Save Building Cian exception, entity:"+buildingCianEntity);
        }
    }

    @Override
    @Transactional
    public BuildingCianEntity update(BuildingCianEntity entity) {
        try {
            log.info("update building");
            BuildingCianEntity entityFromBd = buildingCianRepository.findById(entity.getId()).orElseThrow();
            patchingMapper.map(entity, entityFromBd);
            return buildingCianRepository.saveAndFlush(entity);
        } catch (Exception e) {
            log.error("update error ", e);
            throw new UpdateException("Update Building Cian Exception, entity:"+ entity);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            log.info("delete building");
            buildingCianRepository.deleteById(id);
        } catch (Exception e) {
            log.error("delete error ", e);
            throw new DeleteException("Delete Building Cian exception, id:"+id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public BuildingCianEntity findById(Long id) {
        log.info("find building by id");
        return buildingCianRepository.findById(id).orElseThrow(()->new FindException("Find Building Cian exception, id:"+id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BuildingCianEntity> findAll(Pageable pageable) {
        log.info("find building pageable");
        try{
            return buildingCianRepository.findAll(pageable);
        }catch(Exception e){
            log.info("findall error",e);
            throw new FindException("Find Building Cian exception");
        }
    }
}
