package com.bl.crm.web.controller;

import com.bl.crm.generic.controller.AbstractControllerImpl;
import com.bl.crm.model.ExampleEntity;
import com.bl.crm.service.ExampleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
@RequestMapping("/example")
@Tag(name = "example-entity", description = "Example")
public class ExampleController extends AbstractControllerImpl<ExampleEntity, ExampleService> {
    public ExampleController(ExampleService service) {
        super(service);
    }
}
