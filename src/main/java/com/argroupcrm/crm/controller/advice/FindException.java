package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.advice.AbstractException;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
public class FindException extends AbstractException {
    public FindException(String msg) {
        super(msg);
    }
}
