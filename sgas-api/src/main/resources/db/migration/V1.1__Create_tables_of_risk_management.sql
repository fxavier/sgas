CREATE TABLE departamento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE,
    descricao VARCHAR(255)
);

CREATE TABLE fatores_ambientais (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE riscos_e_impactos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE arias (
    id BIGSERIAL PRIMARY KEY,
    departamento_id BIGINT,
    actividade VARCHAR(255),
    riscos_e_impactos_id BIGINT,
    factor_ambiental_id BIGINT,
    ciclo_de_vida VARCHAR(255),
    estatuto VARCHAR(255),
    extensao VARCHAR(255),
    duracao VARCHAR(255),
    intensidade VARCHAR(255),
    probabilidade VARCHAR(255),
    significancia VARCHAR(255),
    descricao_das_medidas TEXT,
    prazo VARCHAR(255),
    avaliacao_da_eficacia TEXT,
    observacoes TEXT,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_actualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT department_fk FOREIGN KEY (departamento_id) REFERENCES departamento(id),
    CONSTRAINT riscos_e_impactos_fk FOREIGN KEY (riscos_e_impactos_id) REFERENCES riscos_e_impactos(id),
    CONSTRAINT factor_ambiental_fk FOREIGN KEY (factor_ambiental_id) REFERENCES fatores_ambientais(id)
   
);
