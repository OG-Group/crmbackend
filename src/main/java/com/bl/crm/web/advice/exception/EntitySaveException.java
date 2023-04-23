package com.example.crm.web.advice.exception;

import com.example.crm.generic.exception.AbstractException;

public class EntitySaveException extends AbstractException {
    public EntitySaveException(String msg) {
        super(msg);
    }
}
