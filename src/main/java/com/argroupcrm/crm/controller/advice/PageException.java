package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.advice.AbstractException;

/**
 * @author ogbozoyan
 * @date 08.03.2023
 */
public class PageException extends AbstractException {
    public PageException(String msg) {
        super(msg);
    }
}
