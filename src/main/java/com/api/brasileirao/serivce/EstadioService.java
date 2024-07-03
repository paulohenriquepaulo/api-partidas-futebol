package com.api.brasileirao.serivce;

import com.api.brasileirao.dto.EstadioResponseDTO;
import com.api.brasileirao.dto.EstadioResquestDTO;
import com.api.brasileirao.exception.ExceptionPersonalizada;
import com.api.brasileirao.mapper.EstadioMapper;
import com.api.brasileirao.model.Estadio;
import com.api.brasileirao.repository.EstadioRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadioService {

    private final EstadioRepository repository;
    private final EstadioMapper estadioMapper;

    public EstadioService(EstadioRepository estadioRepository, EstadioMapper estadioMapper) {
        this.repository = estadioRepository;
        this.estadioMapper = estadioMapper;
    }

    public EstadioResponseDTO cadastrar(EstadioResquestDTO dto) {
        validarEstadio(dto);
        Estadio estadio = repository.save(estadioMapper.toEstadio(dto));
        return estadioMapper.toEstadioResponseDTO(estadio);
    }

    private void validarEstadio(EstadioResquestDTO dto) {
        if (dto.getNomeEstadio().length() < 3) {
            throw new ExceptionPersonalizada("O nome do estadio deve ser maior que 3 letras!", 400);
        }

        if (repository.existsByNomeEstadio(dto.getNomeEstadio())) {
            throw new ExceptionPersonalizada("Já existe um estadio cadastrado com esse nome!", 409);
        }

        if (dto.getCapacidadeMaxima() <= 0) {
            throw new ExceptionPersonalizada("A capacidade maxima não pode ser menor ou igual a zero!", 400);
        }
    }

}
