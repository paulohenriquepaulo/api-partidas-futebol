package com.api.brasileirao.mapper;

import com.api.brasileirao.dto.EstadioResponseDTO;
import com.api.brasileirao.dto.EstadioResquestDTO;
import com.api.brasileirao.model.Estadio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class EstadioMapper {

    private final ModelMapper modelMapper;

    public EstadioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Estadio toEstadio(EstadioResquestDTO dto) {
        return modelMapper.map(dto, Estadio.class);
    }
    public EstadioResponseDTO toEstadioResponseDTO(Estadio estadio) {
        return modelMapper.map(estadio, EstadioResponseDTO.class);
    }
}
