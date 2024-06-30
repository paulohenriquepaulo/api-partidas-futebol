package com.api.brasileirao.advice;

import com.api.brasileirao.exception.ExceptionPersonalizada;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceException {


    @ExceptionHandler(ExceptionPersonalizada.class)
    public ResponseEntity<Map<String, String>> exceptionPersonalizada(ExceptionPersonalizada exceptionPersonalizada) {
        Map<String, String> errors = new HashMap<>();
        errors.put("mensagem", exceptionPersonalizada.getErrors().get("mensagem"));
        errors.put("status", String.valueOf(exceptionPersonalizada.getStatus().value()));
        return ResponseEntity.status(exceptionPersonalizada.getStatus()).body(errors);
    }
}
