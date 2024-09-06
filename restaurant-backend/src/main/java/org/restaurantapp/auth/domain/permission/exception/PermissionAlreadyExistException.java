package org.restaurantapp.auth.domain.permission.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class PermissionAlreadyExistException extends AppException {
    public PermissionAlreadyExistException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
