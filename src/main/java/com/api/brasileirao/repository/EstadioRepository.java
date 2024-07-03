package com.api.brasileirao.repository;

import com.api.brasileirao.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    boolean existsByNomeEstadio(String nomeEstadio);
}
