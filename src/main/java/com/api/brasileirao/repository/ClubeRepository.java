package com.api.brasileirao.repository;

import com.api.brasileirao.enuns.EstadoEnum;
import com.api.brasileirao.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeClubeAndEstado(String nomeClube, EstadoEnum estado);
}
