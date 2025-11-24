package com.dimensionalengenharia.backend.controllers;


import com.dimensionalengenharia.backend.dtos.AbastecimentoRequest;
import com.dimensionalengenharia.backend.dtos.AbastecimentoResponse;
import com.dimensionalengenharia.backend.services.AbastecimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abastecimentos")
public class AbastecimentoController {
    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @PostMapping
    public ResponseEntity<AbastecimentoResponse> createAbastecimento(@RequestBody AbastecimentoRequest registro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abastecimentoService.createRegistroAbastecimento(registro));
    }

}
