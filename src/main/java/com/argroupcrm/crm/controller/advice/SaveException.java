package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.AbstractException;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
public class SaveException extends AbstractException {
    public SaveException(String msg) {
        super(msg);
    }
}
