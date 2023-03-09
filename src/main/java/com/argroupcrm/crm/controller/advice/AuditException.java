package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.advice.AbstractException;

/**
 * @author ogbozoyan
 * @date 09.03.2023
 */
public class AuditException extends AbstractException {
    public AuditException(String msg) {
        super(msg);
    }
}
