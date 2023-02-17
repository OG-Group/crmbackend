package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.AbstractException;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
public class FindException extends AbstractException {
    public FindException(String msg) {
        super(msg);
    }
}
