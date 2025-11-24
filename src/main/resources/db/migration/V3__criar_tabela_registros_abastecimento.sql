-- V3__criar_tabela_abastecimentos.sql

CREATE TABLE tb_abastecimentos(
    id BIGSERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    latitude DECIMAL(10, 8),
    longitude DECIMAL(11, 8),
    obra_id VARCHAR(20) NOT NULL,
    comboio_id BIGSERIAL NOT NULL,
    equipamento_abastecido_id BIGSERIAL NOT NULL,
    nome_motorista VARCHAR(120),
    foto_motorista_url VARCHAR(255),
    medidor_inicial DECIMAL(10, 2) NOT NULL,
    foto_medidor_inicial_url VARCHAR(255) NOT NULL,
    medidor_final DECIMAL(10, 2) NOT NULL,
    foto_medidor_final_url VARCHAR(255) NOT NULL,
    numero_lacre VARCHAR(255),
    foto_lacre_url VARCHAR(255),
    horimetro_equipamento DECIMAL(10, 2),
    foto_horimetro_url VARCHAR(255),
    observacao_horimetro VARCHAR(255),
    hodometro_equipamento DECIMAL(10, 2),
    foto_hodometro_url VARCHAR(255),
    observacao_hodometro VARCHAR(255),

    FOREIGN KEY (obra_id) REFERENCES tb_obras(id),
    FOREIGN KEY (comboio_id) REFERENCES tb_equipamentos(id),
    FOREIGN KEY (equipamento_abastecido_id) REFERENCES tb_equipamentos(id)
)