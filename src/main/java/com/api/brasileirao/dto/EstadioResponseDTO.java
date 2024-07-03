package com.api.brasileirao.dto;

import com.api.brasileirao.enuns.EstadoEnum;
import lombok.Data;

@Data
public class EstadioResponseDTO {

    private Long id;
    private String nomeEstadio;
    private Double capacidadeMaxima;
    private EstadoEnum estado;
}
