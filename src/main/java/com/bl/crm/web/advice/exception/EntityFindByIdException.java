package com.example.crm.web.advice.exception;

import com.example.crm.generic.exception.AbstractException;

public class EntityFindByIdException extends AbstractException {
    public EntityFindByIdException(String msg) {
        super(msg);
    }
}
