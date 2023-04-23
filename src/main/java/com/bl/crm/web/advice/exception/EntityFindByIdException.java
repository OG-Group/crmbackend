package com.bl.crm.web.advice.exception;

import com.bl.crm.generic.exception.AbstractException;

public class EntityFindByIdException extends AbstractException {
    public EntityFindByIdException(String msg) {
        super(msg);
    }
}
