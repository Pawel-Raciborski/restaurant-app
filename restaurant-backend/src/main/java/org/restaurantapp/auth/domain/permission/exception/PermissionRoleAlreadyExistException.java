package org.restaurantapp.auth.domain.permission.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class PermissionRoleAlreadyExistException extends AppException {
    public PermissionRoleAlreadyExistException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
