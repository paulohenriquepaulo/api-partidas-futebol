package com.api.brasileirao.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ExceptionPersonalizada extends RuntimeException {

    private final Map<String, String> errors;

    private HttpStatus status;


    public ExceptionPersonalizada(String descricao, int status) {
        this.errors = new HashMap<>();
        this.status = HttpStatus.valueOf(status);
        errors.put("mensagem", descricao);
    }
}
