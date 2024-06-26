package com.ipn.mx.AlumnoAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", System.currentTimeMillis());
        errors.put("status", HttpStatus.BAD_REQUEST.value());
        errors.put("error", "Bad Request");
        errors.put("message", "Validation failed for object='alumno'. Error count: " + ex.getBindingResult().getErrorCount());
        errors.put("errors", ex.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> {
                Map<String, String> errorDetails = new HashMap<>();
                errorDetails.put("field", fieldError.getField());
                errorDetails.put("message", fieldError.getDefaultMessage());
                return errorDetails;
            })
            .collect(Collectors.toList()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralExceptions(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
