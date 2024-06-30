package com.api.brasileirao.enuns;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ATIVO("A"), INATIVO("I");

    String valor;

    StatusEnum(String valor) {
        this.valor = valor;
    }


}
