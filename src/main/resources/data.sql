INSERT INTO CLIENT(ID_CLIENT, CPF_CLIENT, EMAIL_CLIENT, NAME_CLIENT) VALUES(1, '12312312300', 'carla@email.com', 'Carla');
INSERT INTO CLIENT(ID_CLIENT, CPF_CLIENT, EMAIL_CLIENT, NAME_CLIENT) VALUES(2, '99999999999', 'maria@email.com', 'Maria');
INSERT INTO CLIENT(ID_CLIENT, CPF_CLIENT, EMAIL_CLIENT, NAME_CLIENT) VALUES(3, '77777777777', 'guilherme@email.com', 'Guilherme');

ALTER SEQUENCE CLIENT_SEQ RESTART WITH 3;


INSERT INTO PRODUCT(ID_PRODUCT, NAME_PRODUCT, DESCRIPTION, PRICE, CATEGORY) VALUES(1,
                                                                                   'Quarterão com Queijo',
                                                                                   'Um hambúrguer (100% carne bovina), queijo processado sabor cheddar, picles, cebola, ketchup, mostarda e pão com gergelim.',
                                                                                   7.00,
                                                                                   'LUNCH');
INSERT INTO PRODUCT(ID_PRODUCT, NAME_PRODUCT, DESCRIPTION, PRICE, CATEGORY) VALUES(2,
                                                                                   'McFritas Grande',
                                                                                   'Deliciosas batatas selecionadas, fritas, crocantes por fora, macias por dentro, douradas, irresistíveis, saborosas, famosas, e todos os outros adjetivos positivos que você quiser dar',
                                                                                   5.38,
                                                                                   'ACCOMPANIMENT');
INSERT INTO PRODUCT(ID_PRODUCT, NAME_PRODUCT, DESCRIPTION, PRICE, CATEGORY) VALUES(3,
                                                                                   'Coca-Cola 500ml',
                                                                                   'Bebida gelada na medida certa para matar sua sede. Refrescante Coca-Cola 500ml',
                                                                                   5.90,
                                                                                   'DRINK');
INSERT INTO PRODUCT(ID_PRODUCT, NAME_PRODUCT, DESCRIPTION, PRICE, CATEGORY) VALUES(4,
                                                                                   'McShake Morango 400ml',
                                                                                   'O novo McShake é feito com leite e batido na hora com calda de morango',
                                                                                   8.99,
                                                                                   'DESSERT');

ALTER SEQUENCE PRODUCT_SEQ RESTART WITH 4;