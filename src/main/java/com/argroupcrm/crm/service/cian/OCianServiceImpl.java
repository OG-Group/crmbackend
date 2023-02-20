package com.argroupcrm.crm.service.cian;

import com.argroupcrm.crm.controller.advice.DeleteException;
import com.argroupcrm.crm.controller.advice.FindException;
import com.argroupcrm.crm.controller.advice.SaveException;
import com.argroupcrm.crm.controller.advice.UpdateException;
import com.argroupcrm.crm.dto.cian.OfficeCianEntityDto;
import com.argroupcrm.crm.generic.crud.dto.CreateResponseDTO;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.repository.cian.OfficeCianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OCianServiceImpl implements OCianService {
    private final OfficeCianRepository officeCianRepository;
    private final ModelMapper patchingMapper;

    @Override
    @Transactional
    public ResponseEntity<CreateResponseDTO> save(OfficeCianEntityDto officeCianEntity) {
        try {
            log.info("createCianOffice");
            OfficeCianEntity fromDto = patchingMapper.map(officeCianEntity, OfficeCianEntity.class);
            if (officeCianRepository.existsById(fromDto.getId())) {
                return ResponseEntity.status(409).build();
            }
            return ResponseEntity.ok(new CreateResponseDTO(officeCianRepository.save(fromDto).getId(), "success"));
        } catch (Exception e) {
            log.error("addCian error ", e);
            throw new SaveException("Save Office Cian exception, entity:" + officeCianEntity);
        }
    }

    @Override
    @Transactional
    public OfficeCianEntity update(OfficeCianEntityDto officeCianEntity) {
        try {
            log.info("update building");
            OfficeCianEntity fromDto = patchingMapper.map(officeCianEntity, OfficeCianEntity.class);
            OfficeCianEntity entityFromBd = officeCianRepository.findById(fromDto.getId()).orElseThrow();
            patchingMapper.map(fromDto, entityFromBd);
            return officeCianRepository.saveAndFlush(fromDto);
        } catch (Exception e) {
            log.error("update error ", e);
            throw new UpdateException("Update Office Cian Exception, entity:" + officeCianEntity);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            log.info("delete building");
            officeCianRepository.deleteById(id);
        } catch (Exception e) {
            log.error("delete error ", e);
            throw new DeleteException("Delete Office Cian exception, id:" + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeCianEntity findById(Long id) {
        log.info("find by id");
        return officeCianRepository.findById(id).orElseThrow(() -> new FindException("Find Office Cian exception, id:" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OfficeCianEntity> findAll(Pageable pageable) {
        try {
            log.info("find all");
            return officeCianRepository.findAll(pageable);
        } catch (Exception e) {
            log.error("find all error ", e);
            throw new FindException("Find Office Cian exception");
        }
    }
}
