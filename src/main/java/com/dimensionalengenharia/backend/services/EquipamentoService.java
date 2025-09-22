package com.dimensionalengenharia.backend.services;

import com.dimensionalengenharia.backend.dtos.EquipamentoDto;
import com.dimensionalengenharia.backend.exceptions.ResourceNotFoundException;
import com.dimensionalengenharia.backend.mappers.EquipamentoMapper;
import com.dimensionalengenharia.backend.models.Equipamento;
import com.dimensionalengenharia.backend.models.Obra;
import com.dimensionalengenharia.backend.repositories.EquipamentoRepository;
import com.dimensionalengenharia.backend.repositories.ObraRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    private final ObraRepository obraRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper mapper;


    public EquipamentoService(ObraRepository obraRepository, EquipamentoRepository equipamentoRepository, EquipamentoMapper mapper) {
        this.obraRepository = obraRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.mapper = mapper;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentoRepository.findAll();
    }

    public List<Equipamento> getEquipamentosByObra(String obraId) {
        return equipamentoRepository.findByObraId(obraId);
    }

    public Equipamento createEquipamento(EquipamentoDto equipamentoDto) {
        Obra obra = obraRepository.findById(equipamentoDto.obraId())
                .orElseThrow(() -> new ResourceNotFoundException("Obra com ID " + equipamentoDto.obraId() + " não encontrado"));

        try {
            Equipamento novoEquipamento = mapper.toEntity(equipamentoDto, obra);
            return equipamentoRepository.save(novoEquipamento);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro ao salvar equipamento, patrimônio ou placa já existem.");
        }
    }

    public Equipamento updateEquipamento(Long id, EquipamentoDto equipamentoDto) {
        Obra obra = obraRepository.findById(equipamentoDto.obraId())
                .orElseThrow(() -> new ResourceNotFoundException("Obra com ID " + equipamentoDto.obraId() + " não encontrado"));
        Equipamento equipamentoExistente = equipamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não foi encontrado."));

        try {
            equipamentoExistente.setObra(obra);
            if (equipamentoDto.patrimonio() != null) {
                equipamentoExistente.setPatrimonio(equipamentoDto.patrimonio().toUpperCase());
            }
            if (equipamentoDto.placa() != null) {
                equipamentoExistente.setPlaca(equipamentoDto.placa().toUpperCase());
            }
            if (equipamentoDto.descricao() != null) {
                equipamentoExistente.setDescricao(equipamentoDto.descricao().toUpperCase());
            }
            if (equipamentoDto.categoria() != null) {
                equipamentoExistente.setCategoria(equipamentoDto.categoria().toUpperCase());
            }
            if (equipamentoDto.empresa() != null) {
                equipamentoExistente.setEmpresa(equipamentoDto.empresa().toUpperCase());
            }

            return equipamentoRepository.save(equipamentoExistente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Erro ao salvar equipamento, patrimônio ou placa já existem.");
        }
    }

    public void deleteEquipamento(Long id) {
        equipamentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipamento não foi encontrado."));
        equipamentoRepository.deleteById(id);
    }
}
