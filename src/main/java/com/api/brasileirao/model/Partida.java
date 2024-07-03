package com.api.brasileirao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CLUBE_MANDANTE_ID")
    private Clube clubeMandante;

    @JoinColumn(name = "CLUBE_VISITANTE_ID")
    @OneToOne
    private Clube clubeVisitante;

    @OneToOne
    @JoinColumn(name = "ESTADIO_ID")
    private Estadio estadio;

    private LocalTime horarioPartida;

    @Column(name = "RESULTADO_MANDANTE")
    private Integer resultadoMandante;

    @Column(name = "RESULTADO_VISITANTE")
    private Integer resultadoVisitante;

    @Column(name = "PUBLICO_PRESENTE")
    private Double publicoPresente;

}
