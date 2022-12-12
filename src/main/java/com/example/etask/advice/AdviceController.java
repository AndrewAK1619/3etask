package com.example.etask.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ArithmeticException.class)
    public ErrorDto handleArithmeticException(ArithmeticException e) {
        return new ErrorDto(e.getMessage());
    }
}
