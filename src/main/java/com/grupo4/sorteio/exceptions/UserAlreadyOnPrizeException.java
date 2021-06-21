package com.grupo4.sorteio.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyOnPrizeException extends AbstractGeneralException {
    public UserAlreadyOnPrizeException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}
