package org.restaurantapp.auth.domain.role.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class RoleExistsException extends AppException {
    public RoleExistsException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
