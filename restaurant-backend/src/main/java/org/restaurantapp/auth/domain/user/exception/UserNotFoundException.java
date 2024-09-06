package org.restaurantapp.auth.domain.user.exception;

import org.restaurantapp.exception.AppException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
