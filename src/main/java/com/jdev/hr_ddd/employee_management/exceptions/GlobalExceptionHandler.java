package com.jdev.hr_ddd.employee_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    ErrorResponseObj errorResponseObj;

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponseObj> handleDuplicateException(SQLIntegrityConstraintViolationException ex) {

        Map<String, String> errorDetail = getErrorMap(ex.getMessage());

        errorResponseObj = new ErrorResponseObj(HttpStatus.CONFLICT.value(), errorDetail, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseObj);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseObj> handleNullAndEmptyException(MethodArgumentNotValidException ex) {

        Map<String, String> errorMessage = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.put(error.getField(), error.getDefaultMessage());
        });

        errorResponseObj = new ErrorResponseObj(HttpStatus.BAD_REQUEST.value(), errorMessage, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseObj);
    }

    private static Map<String, String> getErrorMap(String errorMessage) {

        Map<String, String> errorMap = new HashMap<>();

        if (errorMessage.contains("(N)")) {
            errorMap.put("ID number", "Duplicate id number");
        }

        if (errorMessage.contains("mail")) {
            errorMap.put("Email", "Duplicate email");
        }

        if (errorMessage.contains("09")) {
            errorMap.put("Phone Number", "Duplicate phone number");
        }

        if (errorMessage.contains(".jpg") || errorMessage.contains(".png")) {
            errorMap.put("Photo name", "Duplicate photo name");
        }

        return errorMap;
    }

}
