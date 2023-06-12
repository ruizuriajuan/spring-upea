package com.ruizuria.ecommerce.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = ErrorResponse.builder()
                .status(status.value())
                .error(status.name())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(status).body(error);
    }


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

    //Para el login: bad credencials, user is disabled
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(Exception ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponse error = ErrorResponse.builder()
                .status(status.value())
                .error(status.name())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(status).body(error);
    }

    //Para jwt
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidException(MethodArgumentNotValidException ex) {

        List<FieldErrorModel> errors = ex.getBindingResult().getAllErrors().stream().map(fieldError -> {
            FieldErrorModel fieldErrorModel = new FieldErrorModel();
            fieldErrorModel.setCode(fieldError.getCode());
            fieldErrorModel.setMessage(fieldError.getDefaultMessage());
            fieldErrorModel.setField(((FieldError) fieldError).getField());
            return fieldErrorModel;
        }).toList();

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setCode(status.value());
        response.setErrors(errors);

        return ResponseEntity.status(status).body(response);
    }*/



}
