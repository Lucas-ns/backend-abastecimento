package com.dimensionalengenharia.backend.services;

import com.dimensionalengenharia.backend.dtos.AbastecimentoRequest;
import com.dimensionalengenharia.backend.dtos.AbastecimentoResponse;
import com.dimensionalengenharia.backend.exceptions.BadRequestException;
import com.dimensionalengenharia.backend.mappers.AbastecimentoMapper;
import com.dimensionalengenharia.backend.exceptions.ResourceNotFoundException;
import com.dimensionalengenharia.backend.models.Equipamento;
import com.dimensionalengenharia.backend.models.Obra;
import com.dimensionalengenharia.backend.models.Abastecimento;
import com.dimensionalengenharia.backend.repositories.EquipamentoRepository;
import com.dimensionalengenharia.backend.repositories.ObraRepository;
import com.dimensionalengenharia.backend.repositories.AbastecimentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AbastecimentoService {
    private final AbastecimentoRepository abastecimentoRepository;
    private final ObraRepository obraRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final AbastecimentoMapper mapper;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository,
                                ObraRepository obraRepository,
                                EquipamentoRepository equipamentoRepository, AbastecimentoMapper mapper) {
        this.abastecimentoRepository = abastecimentoRepository;
        this.obraRepository = obraRepository;
        this.equipamentoRepository = equipamentoRepository;
        this.mapper = mapper;
    }

    @Transactional
    public AbastecimentoResponse createRegistroAbastecimento(AbastecimentoRequest abastecimentoRequest) {
        Obra obra = obraRepository.findById(abastecimentoRequest.obraId())
                .orElseThrow(() -> new ResourceNotFoundException("Obra com ID " + abastecimentoRequest.obraId() + " não encontrada"));

        Equipamento comboio = equipamentoRepository.findByPatrimonio(abastecimentoRequest.patrimonioComboio())
                .orElseThrow(() -> new ResourceNotFoundException("Comboio não foi encontrado."));

        Equipamento equipamento = equipamentoRepository.findByPatrimonio(abastecimentoRequest.patrimonioEquipamento())
                .orElseThrow(() -> new ResourceNotFoundException("Equipamento não foi encontrado."));

        checarHorimetroEHodometroDiferenteDeNull(abastecimentoRequest.horimetroEquipamento(), abastecimentoRequest.hodometroEquipamento());
        verificarMedidorInicialMenorQueMedidorFinal(abastecimentoRequest.medidorInicial(), abastecimentoRequest.medidorFinal());
        Abastecimento registro = mapper.toEntity(abastecimentoRequest);
        registro.setObra(obra);
        registro.setComboioId(comboio);
        registro.setEquipamentoAbastecidoId(equipamento);

        return mapper.toResponse(abastecimentoRepository.save(registro));
    }


    private void checarHorimetroEHodometroDiferenteDeNull(BigDecimal horimetro, BigDecimal hodometro) {
        if(horimetro == null && hodometro == null) {
            throw new BadRequestException("Horímetro e hodômetro não podem ser nulos.");
        }
    }

    private void verificarMedidorInicialMenorQueMedidorFinal(BigDecimal medidorInicial, BigDecimal medidorFinal) {
        if(medidorFinal.compareTo(medidorInicial) <= 0) {
            throw new BadRequestException("Medidor inicial deve ser menor do que medidor final");
        }

    }
}
