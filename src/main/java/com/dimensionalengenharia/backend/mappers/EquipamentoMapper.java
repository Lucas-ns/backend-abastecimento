package com.dimensionalengenharia.backend.mappers;

import com.dimensionalengenharia.backend.dtos.EquipamentoDto;
import com.dimensionalengenharia.backend.models.Equipamento;
import com.dimensionalengenharia.backend.models.Obra;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {
    public Equipamento toEntity(EquipamentoDto dto, Obra obra) {
        Equipamento equipamento = new Equipamento();
        equipamento.setPatrimonio(dto.patrimonio());
        equipamento.setPlaca(dto.placa());
        equipamento.setDescricao(dto.descricao().toUpperCase());
        equipamento.setCategoria(dto.categoria().toUpperCase());
        equipamento.setEmpresa(dto.empresa());
        equipamento.setObra(obra);
        return equipamento;
    }

    public EquipamentoDto toDto(Equipamento equipamento) {
        return new EquipamentoDto(
                equipamento.getPatrimonio(),
                equipamento.getPlaca(),
                equipamento.getDescricao(),
                equipamento.getCategoria(),
                equipamento.getObra().getId(),
                equipamento.getEmpresa()
        );
    }
}
