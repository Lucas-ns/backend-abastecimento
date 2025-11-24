package com.dimensionalengenharia.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EquipamentoDto(
        Long id,
        String patrimonio,
        String placa,
        String descricao,
        String categoria,
        @JsonProperty("obra_id")
        String obraId,
        String empresa
) {}
