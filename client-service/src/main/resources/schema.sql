-- Criação da tabela CLIENT
CREATE TABLE IF NOT EXISTS CLIENT (
    ID_CLIENT BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME_CLIENT VARCHAR(255) NOT NULL,
    CPF_CLIENT VARCHAR(11) NOT NULL UNIQUE,
    EMAIL_CLIENT VARCHAR(255) NOT NULL
);

-- Configurar os valores iniciais de AUTO_INCREMENT
ALTER TABLE CLIENT AUTO_INCREMENT = 3;