package com.grupo4.sorteio.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractGeneralException {
    public UserNotFoundException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}
