package com.argroupcrm.crm.controller.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.Date;

/**
 * @author ogbozoyan
 * @date 17.02.2023
 */
@RestControllerAdvice
public class CustomControllerAdvice {
    private static final Integer INTERNAL_SERVER_ERROR = 500; //INTERNAL_SERVER_ERROR
    private static final Integer NOT_FOUND = 400;
    private static final Integer FORBIDDEN = 403;

    @ExceptionHandler(SaveException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> saveException(SaveException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DeleteException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> deleteException(DeleteException er, WebRequest req) {
        if (er.getMessage().contains("not found")) {
            return deleteExceptionNotFound(er, req);
        } else {
            CustomErrorMessage errorMessage = new CustomErrorMessage(
                    INTERNAL_SERVER_ERROR,
                    new Date(),
                    er.getMessage(),
                    req.getDescription(false)
            );
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(DeleteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> deleteExceptionNotFound(DeleteException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                NOT_FOUND,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> pageException(PageException er, WebRequest req) {
        if (er.getMessage().equals("No entities found")) {
            return pageExceptionNotFound(er, req);
        } else {
            CustomErrorMessage errorMessage = new CustomErrorMessage(
                    INTERNAL_SERVER_ERROR,
                    new Date(),
                    er.getMessage(),
                    req.getDescription(false)
            );
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(PageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> pageExceptionNotFound(PageException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                NOT_FOUND,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FilterException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> filterException(FilterException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> findException(FindException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                NOT_FOUND,
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
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> illegalArgsException(IllegalArgumentException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> optimisticException(OptimisticLockingFailureException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> persistenceException(PersistenceException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaSystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> jpaException(JpaSystemException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionSystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> transactionSystemException(TransactionSystemException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> dataIntegrityException(DataIntegrityViolationException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FilterFieldTypeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> fieldTypeException(FilterFieldTypeException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> invalidDataAccessException(InvalidDataAccessApiUsageException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomErrorMessage> badJsonException(IllegalStateException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(true)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> jpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> entityNotFoundException(EntityNotFoundException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                NOT_FOUND,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuditException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<CustomErrorMessage> authenticationException(AuditException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                NOT_FOUND,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorMessage> runtimeException(RuntimeException er, WebRequest req) {
        CustomErrorMessage errorMessage = new CustomErrorMessage(
                INTERNAL_SERVER_ERROR,
                new Date(),
                er.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}