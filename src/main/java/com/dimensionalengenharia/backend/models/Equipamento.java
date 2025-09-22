package com.dimensionalengenharia.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patrimonio;
    private String placa;
    private String descricao;
    private String categoria;
    @OneToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;
    private String empresa;
}
