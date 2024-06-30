package com.api.brasileirao.dto;

import com.api.brasileirao.enuns.EstadoEnum;
import com.api.brasileirao.enuns.StatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClubeResponseDTO {

    private Long id;
    private String nomeClube;
    private EstadoEnum estado;
    private StatusEnum statusClube;
    private LocalDate dataCriacao;
}
