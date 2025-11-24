package com.dimensionalengenharia.backend.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_abastecimentos")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;

    // --- Relacionamentos com entidades ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_id", nullable = false)
    private Obra obra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comboio_id", nullable = false)
    private Equipamento comboioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_abastecido_id", nullable = false)
    private Equipamento equipamentoAbastecidoId;


    @Column(name = "medidor_inicial", nullable = false)
    private BigDecimal medidorInicial;
    @Column(name = "foto_medidor_inicial_url", nullable = false)
    private String fotoMedidorInicialUrl;
    @Column(name = "medidor_final", nullable = false)
    private BigDecimal medidorFinal;
    @Column(name = "foto_medidor_final_url", nullable = false)
    private String fotoMedidorFinalUrl;
    @Column(name = "numero_lacre")
    private String numeroLacre;
    @Column(name = "foto_lacre_url")
    private String fotoLacreUrl;


    @Column(name = "nome_motorista")
    private String nomeMotorista;
    @Column(name = "foto_motorista_url")
    private String fotoMotoristaUrl;

    @Column(name = "horimetro_equipamento", precision = 10, scale = 2)
    private BigDecimal horimetroEquipamento;
    @Column(name = "foto_horimetro_url")
    private String fotoHorimetroUrl;
    @Column(name = "observacao_horimetro", columnDefinition = "TEXT")
    private String observacaoHorimetro;

    @Column(name = "hodometro_equipamento", precision = 10, scale = 2)
    private BigDecimal hodometroEquipamento;
    @Column(name = "foto_hodometro_url")
    private String fotoHodometroUrl;
    @Column(name = "observacao_hodometro", columnDefinition = "TEXT")
    private String observacaoHodometro;

//    @PrePersist
//    public void prePersist() {
//        this.dataHora = LocalDateTime.now();
//    }
}
