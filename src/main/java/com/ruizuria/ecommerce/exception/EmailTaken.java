package com.ruizuria.ecommerce.exception;

public class EmailTaken extends RuntimeException{
    private static final String ERROR_MESSAGE = "Email %s is already taken";

    public EmailTaken(String email) {
        super(String.format(ERROR_MESSAGE, email));
    }
}
