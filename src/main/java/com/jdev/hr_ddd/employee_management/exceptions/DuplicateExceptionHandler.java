package com.jdev.hr_ddd.employee_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DuplicateExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> execute(SQLIntegrityConstraintViolationException ex) {
        Map<String, Object> responseBody = new HashMap<>();
        String message = truncateMessage(ex.getMessage());

        responseBody.put("HttpStatusCode", HttpStatus.CONFLICT.value());
        responseBody.put("message", message);

        return new ResponseEntity<>(responseBody, HttpStatus.CONFLICT);
    }

    private String truncateMessage(String message) {
        int index = message.indexOf(" for ");
        if (index != -1) {
            return message.substring(0, index);
        }
        return message;
    }
}
