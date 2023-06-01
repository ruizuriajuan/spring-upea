package com.ruizuria.ecommerce.exception;

public class RoleDuplicated extends RuntimeException {
    private static final String ERROR_MESSAGE = "Role with name %s already exists";

    public RoleDuplicated(String roleDsc) {
        super(String.format(ERROR_MESSAGE, roleDsc));
    }

}
