-- Creating table for DocumentType
CREATE TABLE tipo_documento (
    codigo BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao TEXT
);

-- Creating table for Documents
CREATE TABLE documentos (
    id BIGSERIAL PRIMARY KEY,
    codigo VARCHAR(255),
    data_criacao TIMESTAMP,
    data_revisao TIMESTAMP,
    nome_documento VARCHAR(255),
    tipo_documento_id BIGINT,
    local_arquivo TEXT,
    estado VARCHAR(255),
    perido_retencao DATE,
    forma_eliminacao VARCHAR(255),
    url TEXT,
    observacao TEXT,
    CONSTRAINT fk_tipo_documento FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento (codigo)
);