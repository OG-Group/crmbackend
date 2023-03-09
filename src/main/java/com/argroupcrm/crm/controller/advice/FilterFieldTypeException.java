package com.argroupcrm.crm.controller.advice;


import com.argroupcrm.crm.generic.crud.controller.advice.AbstractException;

/**
 * @author ogbozoyan
 * @date 03.03.2023
 */
public class FilterFieldTypeException extends AbstractException {
    public FilterFieldTypeException(String msg) {
        super(msg);
    }
}
