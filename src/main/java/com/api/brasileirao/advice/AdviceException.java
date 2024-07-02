package com.api.brasileirao.advice;

import com.api.brasileirao.dto.BaseResponseDTO;
import com.api.brasileirao.exception.ExceptionPersonalizada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceException {

    private static final String ERRO = "erro";

    @ExceptionHandler(ExceptionPersonalizada.class)
    public ResponseEntity<BaseResponseDTO> exceptionPersonalizada(ExceptionPersonalizada exceptionPersonalizada) {
        Map<String, String> errors = new HashMap<>();
        errors.put("mensagem", exceptionPersonalizada.getErrors().get("mensagem"));
        return ResponseEntity.status(exceptionPersonalizada.getStatus())
                .body(new BaseResponseDTO(exceptionPersonalizada.getStatus().value(),ERRO, errors));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseResponseDTO> httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("mensagem", exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponseDTO(HttpStatus.BAD_REQUEST.value(), ERRO, errors));
    }


}
