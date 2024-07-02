package com.api.brasileirao.dto;

import lombok.Data;

@Data
public class BaseResponseDTO {

    private Integer status;
    private String mensagem;
    private Object data;

    public BaseResponseDTO(Integer status,String mensagem, Object data) {
        this.status = status;
        this.mensagem = mensagem;
        this.data = data;
    }
}
