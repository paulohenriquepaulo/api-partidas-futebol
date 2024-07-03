package com.api.brasileirao.controller;

import com.api.brasileirao.dto.BaseResponseDTO;
import com.api.brasileirao.dto.EstadioResquestDTO;
import com.api.brasileirao.exception.ExceptionPersonalizada;
import com.api.brasileirao.serivce.EstadioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadio")
public class EstadioController extends BaseController {

    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO> cadastrar(@RequestBody EstadioResquestDTO dto) {
        return created(estadioService.cadastrar(dto));
    }


}
