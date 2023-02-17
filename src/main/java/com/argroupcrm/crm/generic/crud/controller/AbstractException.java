package com.argroupcrm.crm.generic.crud.controller;

import lombok.Data;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
@Data
public class AbstractException extends RuntimeException{
    private static final long serialVersionUID = 1L;


    public AbstractException(String msg){
        super(msg);
    }
}
