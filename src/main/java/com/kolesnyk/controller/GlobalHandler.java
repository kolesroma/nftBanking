package com.kolesnyk.controller;

import com.kolesnyk.exception.EntityNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFound.class, ConstraintViolationException.class})
    public Map<String, String> entityValidation(RuntimeException e) {
        return Map.of("code", "400",
                "message", e.getMessage());
    }
}
