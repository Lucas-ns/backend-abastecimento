package com.dimensionalengenharia.backend.controllers;


import com.dimensionalengenharia.backend.models.Obra;
import com.dimensionalengenharia.backend.services.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public ResponseEntity<List<Obra>> getAllObras() {
        return ResponseEntity.ok().body(obraService.getObras());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> getObraById(@PathVariable String id) {
        Obra obra = obraService.getObraById(id);
        return ResponseEntity.ok(obra);
    }

    @PostMapping
    public ResponseEntity<Void> createObra(@RequestBody Obra obra) {
        obraService.createObra(obra);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObra(@PathVariable String id) {
        obraService.deleteObra(id);
        return ResponseEntity.noContent().build();
    }
}
