package com.bl.crm.service;

import com.bl.crm.repository.ExampleRepository;
import com.bl.crm.generic.service.AbstractServiceImpl;
import com.bl.crm.model.ExampleEntity;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends AbstractServiceImpl<ExampleEntity, ExampleRepository> {
    public ExampleService(ExampleRepository repository) {
        super(repository);
    }
}
