package com.api.brasileirao.controller;

import com.api.brasileirao.dto.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    private static final String SUCESSO = "sucess";

    protected ResponseEntity<BaseResponseDTO> created(Object data) {
        return sucesso(HttpStatus.CREATED.value(), data);
    }
    protected ResponseEntity<BaseResponseDTO> ok(Object data) {
        return sucesso(HttpStatus.OK.value(), data);
    }
    protected ResponseEntity<BaseResponseDTO> sucesso(Integer code, Object data) {
        return ResponseEntity.status(code).body(new BaseResponseDTO(code,SUCESSO,  data));
    }
}
