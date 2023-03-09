package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.generic.crud.controller.AbstractControllerImpl;
import com.argroupcrm.crm.generic.crud.service.AbstractService;
import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.service.cian.BCianServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/api/cian/building")
public class BuildingCianController extends AbstractControllerImpl<BuildingCianEntity, BCianServiceImpl> {
    public BuildingCianController(AbstractService<BuildingCianEntity> service) {
        super(service);
    }
}
