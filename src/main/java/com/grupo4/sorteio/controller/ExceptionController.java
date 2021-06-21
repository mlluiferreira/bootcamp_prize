package com.grupo4.sorteio.controller;

import com.grupo4.sorteio.dtos.ErrorInfoDTO;
import com.grupo4.sorteio.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AbstractGeneralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, Exception exception) {
        ErrorInfoDTO errorInfo = ErrorInfoDTO.create(req, exception);
        return new ResponseEntity<>(errorInfo, errorInfo.statusCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> captureEx(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new TreeMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
