package com.api.brasileirao.repository;

import com.api.brasileirao.enuns.EstadoEnum;
import com.api.brasileirao.enuns.StatusEnum;
import com.api.brasileirao.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    boolean existsByNomeClubeAndEstado(String nomeClube, EstadoEnum estado);


    @Query(value = "SELECT * FROM clube c " +
            "WHERE " +
            "( :estadoEnum IS NOT NULL AND c.estado_sede = :estadoEnum ) " +
            "OR ( :statusEnum IS NOT NULL AND c.status_clube = :statusEnum ) " +
            "OR ( :nome IS NOT NULL AND c.nome_clube = :nome ) " +
            "ORDER BY " +
            "CASE " +
            "WHEN :estadoEnum IS NOT NULL THEN c.estado_sede " +
            "WHEN :nome IS NOT NULL THEN c.nome_clube " +
            "ELSE c.estado_sede " +
            "END DESC",
            nativeQuery = true)
    List<Clube> buscarPorFiltro( String nome, String estadoEnum, String statusEnum);
}
