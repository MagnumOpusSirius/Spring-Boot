package com.demo.BootApp.advice;

import com.demo.BootApp.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    //predefined exception below
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidInput(MethodArgumentNotValidException ex){
        Map<String, String> errorMap= new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error-> {errorMap.put(error.getField(), error.getDefaultMessage());});
        return errorMap;
    }

    //custom exception below
    //example of when this exception is thrown: http://localhost:8080/users/100
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleBusinessException(UserNotFoundException ex){
        Map<String, String> errorMap= new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }

}
