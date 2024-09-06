package org.restaurantapp.auth.domain.permission.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class PermissionNotFoundException extends AppException {
    public PermissionNotFoundException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
