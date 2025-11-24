package com.dimensionalengenharia.backend.dtos;

import com.dimensionalengenharia.backend.models.Equipamento;
import com.dimensionalengenharia.backend.models.Obra;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AbastecimentoResponse(
        Long id,
        LocalDateTime dataHora,
        BigDecimal latitude,
        BigDecimal longitude,
        Obra obra,
        Equipamento patrimonioComboio,
        Equipamento patrimonioEquipamento,
        String nomeMotorista,
        String fotoMotoristaUrl,
        BigDecimal medidorInicial,
        String fotoMedidorInicialUrl,
        BigDecimal medidorFinal,
        String fotoMedidorFinalUrl,
        String numeroLacre,
        String fotoLacreUrl,
        BigDecimal horimetroEquipamento,
        String fotoHorimetroUrl,
        String observacaoHorimetro,
        BigDecimal hodometroEquipamento,
        String fotoHodometroUrl,
        String observacaoHodometro
) {
}