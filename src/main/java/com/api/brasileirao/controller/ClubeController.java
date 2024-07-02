package com.api.brasileirao.controller;

import com.api.brasileirao.dto.ClubeResponseDTO;
import com.api.brasileirao.dto.ClubeResquestDTO;
import com.api.brasileirao.serivce.ClubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping
    public ResponseEntity<String> cadastrar(@RequestParam Long id, @RequestBody ClubeResquestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(clubeService.editar(id, dto));
    }
}
