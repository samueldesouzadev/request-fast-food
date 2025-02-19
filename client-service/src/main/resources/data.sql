-- Limpa as tabelas CLIENT
DELETE FROM CLIENT;

-- Reseta os IDs (se necessário)
ALTER TABLE CLIENT AUTO_INCREMENT = 1;

-- Reinsere os dados
INSERT INTO CLIENT (CPF_CLIENT, EMAIL_CLIENT, NAME_CLIENT)
VALUES
('12312312300', 'carla@email.com', 'Carla'),
('99999999999', 'maria@email.com', 'Maria'),
('77777777777', 'guilherme@email.com', 'Guilherme');