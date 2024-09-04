package org.restaurantapp.auth.domain.role.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends AppException {
    public RoleNotFoundException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
