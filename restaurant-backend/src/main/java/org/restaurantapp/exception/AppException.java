package org.restaurantapp.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class AppException extends RuntimeException{
    private final String message;
    private final HttpStatus httpStatus;
}
