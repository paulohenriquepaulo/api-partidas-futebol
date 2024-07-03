package com.api.brasileirao.model;

import com.api.brasileirao.enuns.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME_ETADIO")
    private String nomeEstadio;
    @Column(name = "CAPACIDADE_MAXIMA")
    private Double capacidadeMaxima;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
    @OneToMany(mappedBy = "estadio")
    private List<Partida> partidas;

}
