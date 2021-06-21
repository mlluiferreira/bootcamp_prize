package com.grupo4.sorteio.exceptions;

import org.springframework.http.HttpStatus;

public class PrizeAlreadyDrawException extends AbstractGeneralException {
    public PrizeAlreadyDrawException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}