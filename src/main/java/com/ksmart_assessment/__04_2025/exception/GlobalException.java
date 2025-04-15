package com.ksmart_assessment.__04_2025.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    // @ExceptionHandler(RuntimeException.class)
    // public ResponseEntity<String> runtimeException(RuntimeException ex){

    //     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    // } 

    @ExceptionHandler(EmployeeIdNotFound.class)
    public ResponseEntity<String> employeeIdNotFound(EmployeeIdNotFound ex){

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    } 
    
}
