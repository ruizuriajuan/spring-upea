package com.ruizuria.ecommerce.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorHandler {

    //@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ExceptionHandler(RoleDuplicated.class)
    public ResponseEntity<ErrorResponse> handleRolDuplicatedException(Exception ex) {
        final String ERROR_MESSAGE = "Role with name %s alredy exists ";
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse error = ErrorResponse.builder()
                .status(status.value())
                .error("Role Name Already Exists")
                .message(ex.getMessage())
                .build();
        //message(String.format(ERROR_MESSAGE, ex.getMessage().split(" ")[6]))
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(EmailTaken.class)
    public ResponseEntity<ErrorResponse> emailTakenException(Exception ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse error = ErrorResponse.builder()
                .status(status.value())
                .error("Email already taken")
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(status).body(error);
    }



}
