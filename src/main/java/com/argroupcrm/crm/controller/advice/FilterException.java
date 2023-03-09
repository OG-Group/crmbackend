package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.advice.AbstractException;

/**
 * @author ogbozoyan
 * @date 08.03.2023
 */
public class FilterException extends AbstractException {
    public FilterException(String msg) {
        super(msg);
    }
}
