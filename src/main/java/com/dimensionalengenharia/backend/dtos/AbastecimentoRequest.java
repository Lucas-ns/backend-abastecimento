package com.dimensionalengenharia.backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AbastecimentoRequest(
        LocalDateTime dataHora,
        BigDecimal latitude,
        BigDecimal longitude,
        String obraId,
        String patrimonioComboio,
        String patrimonioEquipamento,
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