package com.app.kuri.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.kuri.Utils.ApiResponse;
import com.app.kuri.Utils.CustomHttpStatus;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class KuriExceptionHandler {

    // Custom Exceptions

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse> userExceptionHandler(UserException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    @ExceptionHandler(OrgException.class)
    public ResponseEntity<ApiResponse> orgExceptionHandler(OrgException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    @ExceptionHandler(ChitException.class)
    public ResponseEntity<ApiResponse> chitExceptionHandler(ChitException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ApiResponse> customerExceptionHandler(CustomerException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    // Super Custom exception

    @ExceptionHandler(KuriException.class)
    public ResponseEntity<ApiResponse> kuriExceptionHandler(KuriException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getErrorMsg());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    // Runtime Exceptions

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse> usernameNotFoundExceptionHandler(UsernameNotFoundException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> constraintViolationExceptionHandler(ConstraintViolationException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    @ExceptionHandler(BadCredentialsException.class)            //TODO not working
    public ResponseEntity<ApiResponse> badCredentialsExceptionHandler(BadCredentialsException e) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    // Runtime Exception

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> runtimeExceptionHandler(RuntimeException e) {
        // Sentry.captureException(ex);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }

    // Exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> exceptionHandler(Exception e) {
        // Sentry.captureException(ex);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse(data, "failed", CustomHttpStatus.FAILED.asStatus()));
    }
}
