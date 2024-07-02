package com.api.brasileirao.controller;

import com.api.brasileirao.dto.BaseResponseDTO;
import com.api.brasileirao.dto.ClubeResquestDTO;
import com.api.brasileirao.serivce.ClubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clube")
public class ClubeController extends BaseController{


    private final ClubeService clubeService;


    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO> cadastrar(@RequestBody ClubeResquestDTO dto) {
        return created(clubeService.cadastrar(dto));
    }

    @PatchMapping
    public ResponseEntity<BaseResponseDTO> editar(@RequestParam Long id, @RequestBody ClubeResquestDTO dto) {
        return ok(clubeService.editar(id, dto));
    }

    @DeleteMapping
    public ResponseEntity inativar(@RequestParam Long id) {
        clubeService.inativarCluebe(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
