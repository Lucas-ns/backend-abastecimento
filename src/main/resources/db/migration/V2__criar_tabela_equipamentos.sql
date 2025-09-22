-- V2__criar_tabela_equipamentos.sql

CREATE TABLE tb_equipamentos(
    id BIGSERIAL PRIMARY KEY,
    patrimonio VARCHAR(50) NOT NULL UNIQUE,
    placa VARCHAR(20) UNIQUE,
    descricao VARCHAR(255) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    obra_id VARCHAR(20) REFERENCES tb_obras(id),
    empresa VARCHAR(255) NOT NULL
)