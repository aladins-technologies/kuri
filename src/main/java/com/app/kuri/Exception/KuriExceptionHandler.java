package com.app.kuri.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class KuriExceptionHandler{

    @ExceptionHandler(KuriException.class)
    public ResponseEntity<?> kuriExceptionHandler(KuriException e){
        return new ResponseEntity<>(e.getErrorMsg(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> userExceptionHandler(UserException e){
        return new ResponseEntity<>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrgException.class)
    public ResponseEntity<?> orgExceptionHandler(OrgException e){
        return new ResponseEntity<>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ChitException.class)
    public ResponseEntity<?> chitExceptionHandler(ChitException e){
        return new ResponseEntity<>(e.getErrorMsg(), HttpStatus.BAD_REQUEST);
    }
}
