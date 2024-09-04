package org.restaurantapp.auth.domain.role.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class UserRoleAlreadyExistsException extends AppException {
    public UserRoleAlreadyExistsException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
