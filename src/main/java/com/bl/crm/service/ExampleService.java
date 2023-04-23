package com.example.crm.service;

import com.example.crm.generic.service.AbstractServiceImpl;
import com.example.crm.model.ExampleEntity;
import com.example.crm.repository.ExampleRepository;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends AbstractServiceImpl<ExampleEntity, ExampleRepository> {
    public ExampleService(ExampleRepository repository) {
        super(repository);
    }
}
