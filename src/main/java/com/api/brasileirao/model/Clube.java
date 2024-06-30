package com.api.brasileirao.model;

import com.api.brasileirao.enuns.EstadoEnum;
import com.api.brasileirao.enuns.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "CLUBE")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME_CLUBE")
    private String nomeClube;
    @Column(name = "ESTADO_SEDE")
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
    @Column(name = "STATUS_CLUBE")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusClube;
    @Column(name = "DATA_CRIACAO")
    private LocalDate dataCriacao;

}
