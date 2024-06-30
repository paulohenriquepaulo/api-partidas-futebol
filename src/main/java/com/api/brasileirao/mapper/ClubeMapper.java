package com.api.brasileirao.mapper;

import com.api.brasileirao.dto.ClubeResponseDTO;
import com.api.brasileirao.dto.ClubeResquestDTO;
import com.api.brasileirao.model.Clube;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class ClubeMapper {

    private final ModelMapper modelMapper;

    public ClubeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Clube toClube(ClubeResquestDTO dto) {
        return modelMapper.map(dto, Clube.class);
    }
    public ClubeResponseDTO toClubeResponseDTO(Clube clube) {
        return modelMapper.map(clube, ClubeResponseDTO.class);
    }
}
