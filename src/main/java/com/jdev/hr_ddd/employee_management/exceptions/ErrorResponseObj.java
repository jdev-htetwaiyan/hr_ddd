package com.jdev.hr_ddd.employee_management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseObj {

    int StatusCode;
    Map<String, String> message;
    LocalDateTime timestamp;

}
