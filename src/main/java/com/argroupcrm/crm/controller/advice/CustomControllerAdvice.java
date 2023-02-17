package com.argroupcrm.crm.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
@RestControllerAdvice
public class CustomControllerAdvice {
    private static final Integer INVALID_ENTITY = 500; //INTERNAL_SERVER_ERROR
    private static final Integer INVALID_JSON = 400; //BAD_REQUEST
    private static final Integer INVALID_TOKEN = 403; //FORBIDDEN
    private static final Integer FIND_ERROR = 404; //NOT_FOUND
    @ExceptionHandler(SaveException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> saveException(SaveException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INVALID_ENTITY,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> deleteException(DeleteException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                FIND_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> findException(FindException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                FIND_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UpdateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> updateException(UpdateException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INVALID_ENTITY,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}