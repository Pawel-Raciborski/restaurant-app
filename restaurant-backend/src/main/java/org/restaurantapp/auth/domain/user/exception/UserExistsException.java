package org.restaurantapp.auth.domain.user.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class UserExistsException extends AppException {
    public UserExistsException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
