package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.controller.advice.DeleteException;
import com.argroupcrm.crm.controller.advice.FindException;
import com.argroupcrm.crm.controller.advice.SaveException;
import com.argroupcrm.crm.controller.advice.UpdateException;
import com.argroupcrm.crm.dto.cian.BuildingCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.auth.UserEntity;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.repository.cian.BuildingCianRepository;
import com.argroupcrm.crm.service.auth.UserService;
import com.argroupcrm.crm.util.XmlCreator;
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
    private final UserService userService;
    private final ModelMapper patchingMapper;

    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(BuildingCianEntity buildingCianEntityDto) {
        try {
            log.info("create building");
            BuildingCianEntity fromDto = patchingMapper.map(buildingCianEntityDto, BuildingCianEntity.class);

            if (buildingCianRepository.existsById(fromDto.getId())) {
                return ResponseEntity.status(409).build();
            }
            BuildingCianEntity newEntity = buildingCianRepository.save(fromDto);

            if (newEntity.getServiceInformationSaveOnCian()) {
                if (newEntity.getCategoryBuilding().toLowerCase().contains("buildingrent")) {
                    XmlCreator feed = new XmlCreator();
                    UserEntity user = userService.getCurrent();

                    Integer countAvailablePremium = user.getPremiumCianCount();

                    feed.CianRentBuildingXML(newEntity, countAvailablePremium);
                }
            }

            return ResponseEntity.ok(new CreateResponseDTO(newEntity.getId(), "success"));
        } catch (Exception e) {
            log.error("create error ", e);
            e.printStackTrace();
            throw new SaveException("Save Building Cian exception, entity:" + buildingCianEntityDto);
        }
    }

    @Override
    @Transactional
    public BuildingCianEntity update(BuildingCianEntityDto entity) {
        try {
            log.info("update building");
            BuildingCianEntity fromDto = patchingMapper.map(entity, BuildingCianEntity.class);
            BuildingCianEntity entityFromBd = buildingCianRepository.findById(fromDto.getId()).orElseThrow();
            patchingMapper.map(fromDto, entityFromBd);
            return buildingCianRepository.saveAndFlush(fromDto);
        } catch (Exception e) {
            log.error("update error ", e);
            e.printStackTrace();
            throw new UpdateException("Update Building Cian Exception, entity:" + entity);
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
            e.printStackTrace();
            throw new DeleteException("Delete Building Cian exception, id:" + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public BuildingCianEntity findById(Long id) {
        log.info("find building by id");
        return buildingCianRepository.findById(id).orElseThrow(() -> new FindException("Find Building Cian exception, id:" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BuildingCianEntity> findAll(Pageable pageable) {
        try {
            log.info("find building pageable");
            return buildingCianRepository.findAll(pageable);
        } catch (Exception e) {
            log.info("findall error", e);
            e.printStackTrace();
            throw new FindException("Find Building Cian exception");
        }
    }
}
