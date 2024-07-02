package com.api.brasileirao.serivce;

import com.api.brasileirao.dto.ClubeResponseDTO;
import com.api.brasileirao.dto.ClubeResquestDTO;
import com.api.brasileirao.enuns.StatusEnum;
import com.api.brasileirao.exception.ExceptionPersonalizada;
import com.api.brasileirao.mapper.ClubeMapper;
import com.api.brasileirao.model.Clube;
import com.api.brasileirao.repository.ClubeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClubeService {


    private final ClubeRepository clubeRepository;
    
    private final ClubeMapper clubeMapper;
    private static final  String CLUBE_EDITADO = "Clube editado com sucesso!";

    public ClubeService(ClubeRepository clubeRepository, ClubeMapper clubeMapper) {
        this.clubeRepository = clubeRepository;
        this.clubeMapper = clubeMapper;
    }

    public ClubeResponseDTO cadastrar(ClubeResquestDTO dto) {
        validarInformacoesClube(dto);
        Clube novoClube = clubeMapper.toClube(dto);
        novoClube.setDataCriacao(dto.getDataCriacao());
        novoClube.setStatusClube(StatusEnum.ATIVO);
        novoClube = clubeRepository.save(novoClube);
        return clubeMapper.toClubeResponseDTO(novoClube);
    }

    public String editar(Long id, ClubeResquestDTO dto) {
        Clube clube = clubeRepository.findById(id)
                .orElseThrow(() -> new ExceptionPersonalizada("O clube não foi encontrado", 404));

        validarInformacoesClube(dto);
        clube.setNomeClube(dto.getNomeClube());
        clube.setEstado(dto.getEstado());
        clube.setDataCriacao(dto.getDataCriacao());
        clubeRepository.save(clube);
        return CLUBE_EDITADO;
    }

    public void inativarCluebe(Long id) {
        Clube clube = clubeRepository.findById(id)
                .orElseThrow(() -> new ExceptionPersonalizada("O clube não foi encontrado", 404));
        if (clube.getStatusClube().equals(StatusEnum.INATIVO))
            throw new ExceptionPersonalizada("O clube já está inativado!", 400);

        clube.setStatusClube(StatusEnum.INATIVO);
        clubeRepository.save(clube);
    }

    private void validarInformacoesClube(ClubeResquestDTO dto) {
        if (dto.getNomeClube().length() < 2) {
            throw new ExceptionPersonalizada("O nome do clube não pode ser menor que 2 letras!", 400);
        }

        if (dto.getDataCriacao().isAfter(LocalDate.now())) {
            throw new ExceptionPersonalizada("A data de criação não pode ser maior que a data atual!", 400);
        }

        if (clubeRepository.existsByNomeClubeAndEstado(dto.getNomeClube(), dto.getEstado())) {
            throw new ExceptionPersonalizada("Já existe um clube cadastrado com esse nome para esse estado!", 409);
        }
    }
}
