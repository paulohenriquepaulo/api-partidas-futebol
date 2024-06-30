package com.api.brasileirao.controller;

import com.api.brasileirao.dto.ClubeResponseDTO;
import com.api.brasileirao.dto.ClubeResquestDTO;
import com.api.brasileirao.serivce.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clube")
public class ClubeController {


    private final ClubeService clubeService;


    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    public ResponseEntity<ClubeResponseDTO> cadastrar(@RequestBody ClubeResquestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeService.cadastrar(dto));
    }
}
