package com.api.brasileirao.dto;

import com.api.brasileirao.enuns.EstadoEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClubeResquestDTO {

    private String nomeClube;
    private EstadoEnum estado;
    private LocalDate dataCriacao;

}
