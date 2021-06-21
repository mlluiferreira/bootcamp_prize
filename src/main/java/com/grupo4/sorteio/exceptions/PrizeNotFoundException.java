package com.grupo4.sorteio.exceptions;

import org.springframework.http.HttpStatus;

public class PrizeNotFoundException extends AbstractGeneralException {
    public PrizeNotFoundException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}
