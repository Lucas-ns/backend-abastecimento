package com.dimensionalengenharia.backend.mappers;

import com.dimensionalengenharia.backend.dtos.AbastecimentoRequest;
import com.dimensionalengenharia.backend.dtos.AbastecimentoResponse;
import com.dimensionalengenharia.backend.models.Abastecimento;
import org.springframework.stereotype.Component;

@Component
public class AbastecimentoMapper {

    public AbastecimentoRequest toDto(Abastecimento abastecimento) {
        if (abastecimento == null) {
            return null;
        }
        return new AbastecimentoRequest(
                abastecimento.getDataHora(),
                abastecimento.getLatitude(),
                abastecimento.getLongitude(),
                abastecimento.getObra().getId(),
                abastecimento.getComboioId().getPatrimonio(),
                abastecimento.getEquipamentoAbastecidoId().getPatrimonio(),
                abastecimento.getNomeMotorista(),
                abastecimento.getFotoMotoristaUrl(),
                abastecimento.getMedidorInicial(),
                abastecimento.getFotoMedidorInicialUrl(),
                abastecimento.getMedidorFinal(),
                abastecimento.getFotoMedidorFinalUrl(),
                abastecimento.getNumeroLacre(),
                abastecimento.getFotoLacreUrl(),
                abastecimento.getHorimetroEquipamento(),
                abastecimento.getFotoHorimetroUrl(),
                abastecimento.getObservacaoHorimetro(),
                abastecimento.getHodometroEquipamento(),
                abastecimento.getFotoHodometroUrl(),
                abastecimento.getObservacaoHodometro()
        );
    }

    public AbastecimentoResponse toResponse(Abastecimento abastecimento) {
        return new AbastecimentoResponse(
                abastecimento.getId(),
                abastecimento.getDataHora(),
                abastecimento.getLatitude(),
                abastecimento.getLongitude(),
                abastecimento.getObra(),
                abastecimento.getComboioId(),
                abastecimento.getEquipamentoAbastecidoId(),
                abastecimento.getNomeMotorista(),
                abastecimento.getFotoMotoristaUrl(),
                abastecimento.getMedidorInicial(),
                abastecimento.getFotoMedidorInicialUrl(),
                abastecimento.getMedidorFinal(),
                abastecimento.getFotoMedidorFinalUrl(),
                abastecimento.getNumeroLacre(),
                abastecimento.getFotoLacreUrl(),
                abastecimento.getHorimetroEquipamento(),
                abastecimento.getFotoHorimetroUrl(),
                abastecimento.getObservacaoHorimetro(),
                abastecimento.getHodometroEquipamento(),
                abastecimento.getFotoHodometroUrl(),
                abastecimento.getObservacaoHodometro()
        );
    }

    public Abastecimento toEntity(AbastecimentoRequest abastecimentoRequest) {
        if (abastecimentoRequest == null) {
            return null;
        }
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setDataHora(abastecimentoRequest.dataHora());
        abastecimento.setLatitude(abastecimentoRequest.latitude());
        abastecimento.setLongitude(abastecimentoRequest.longitude());
        abastecimento.setNomeMotorista(abastecimentoRequest.nomeMotorista());
        abastecimento.setFotoMotoristaUrl(abastecimentoRequest.fotoMotoristaUrl());
        abastecimento.setMedidorInicial(abastecimentoRequest.medidorInicial());
        abastecimento.setFotoMedidorInicialUrl(abastecimentoRequest.fotoMedidorInicialUrl());
        abastecimento.setMedidorFinal(abastecimentoRequest.medidorFinal());
        abastecimento.setFotoMedidorFinalUrl(abastecimentoRequest.fotoMedidorFinalUrl());
        abastecimento.setNumeroLacre(abastecimentoRequest.numeroLacre());
        abastecimento.setFotoLacreUrl(abastecimentoRequest.fotoLacreUrl());
        abastecimento.setHorimetroEquipamento(abastecimentoRequest.horimetroEquipamento());
        abastecimento.setFotoHorimetroUrl(abastecimentoRequest.fotoHorimetroUrl());
        abastecimento.setObservacaoHorimetro(abastecimentoRequest.observacaoHorimetro());
        abastecimento.setHodometroEquipamento(abastecimentoRequest.hodometroEquipamento());
        abastecimento.setFotoHodometroUrl(abastecimentoRequest.fotoHodometroUrl());
        abastecimento.setObservacaoHodometro(abastecimentoRequest.observacaoHodometro());
        return abastecimento;
    }
}