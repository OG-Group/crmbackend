package com.argroupcrm.crm.controller.cian;

import com.argroupcrm.crm.generic.crud.controller.AbstractControllerImpl;
import com.argroupcrm.crm.generic.crud.service.AbstractService;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
import com.argroupcrm.crm.service.cian.OCianServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/cian/office")
@Slf4j
public class OfficeCianController extends AbstractControllerImpl<OfficeCianEntity, OCianServiceImpl> {

    public OfficeCianController(AbstractService<OfficeCianEntity> service) {
        super(service);
    }
}
