package com.dimensionalengenharia.backend.controllers;


import com.dimensionalengenharia.backend.dtos.EquipamentoDto;
import com.dimensionalengenharia.backend.mappers.EquipamentoMapper;
import com.dimensionalengenharia.backend.models.Equipamento;
import com.dimensionalengenharia.backend.services.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;
    private final EquipamentoMapper mapper;

    public EquipamentoController(EquipamentoService equipamentoService, EquipamentoMapper mapper) {
        this.equipamentoService = equipamentoService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoDto>> getEquipamentos() {
        List<EquipamentoDto> listaEquipamentos = equipamentoService.getEquipamentos().stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(listaEquipamentos);
    }

    @GetMapping("/{obraId}")
    public ResponseEntity<List<EquipamentoDto>> getEquipamentosByObra(@PathVariable String obraId) {
        List<EquipamentoDto> listaEquipamentos = equipamentoService.getEquipamentosByObra(obraId).stream().map(mapper::toDto).toList();
        return ResponseEntity.ok(listaEquipamentos);
    }

    @PostMapping
    public ResponseEntity<EquipamentoDto> createEquipamento(@RequestBody EquipamentoDto equipamentoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(equipamentoService.createEquipamento(equipamentoDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipamentoDto> updateEquipamento(@PathVariable Long id, @RequestBody EquipamentoDto equipamentoDto) {
        return ResponseEntity.ok().body(mapper.toDto(equipamentoService.updateEquipamento(id, equipamentoDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable Long id) {
        equipamentoService.deleteEquipamento(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
