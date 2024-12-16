-- Limpa as tabelas CLIENT e PRODUCT
DELETE FROM CLIENT;
DELETE FROM PRODUCT;

-- Reseta os IDs (se necessário)
ALTER TABLE CLIENT AUTO_INCREMENT = 1;
ALTER TABLE PRODUCT AUTO_INCREMENT = 1;

-- Reinsere os dados
INSERT INTO CLIENT (CPF_CLIENT, EMAIL_CLIENT, NAME_CLIENT)
VALUES
('12312312300', 'carla@email.com', 'Carla'),
('99999999999', 'maria@email.com', 'Maria'),
('77777777777', 'guilherme@email.com', 'Guilherme');

INSERT INTO PRODUCT (NAME_PRODUCT, DESCRIPTION, PRICE, CATEGORY)
VALUES
('Quarterão com Queijo', 'Um hambúrguer (100% carne bovina), queijo processado sabor cheddar, picles, cebola, ketchup, mostarda e pão com gergelim.', 7.00, 'LUNCH'),
('McFritas Grande', 'Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar', 5.38, 'ACCOMPANIMENT'),
('Coca-Cola 500ml', 'Bebida gelada na medida certa para matar sua sede. Refrescante Coca-Cola 500ml', 5.90, 'DRINK'),
('McShake Morango 400ml', 'O novo McShake é feito com leite e batido na hora com calda de morango', 8.99, 'DESSERT');
