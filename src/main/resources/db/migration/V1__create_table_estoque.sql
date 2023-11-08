CREATE SCHEMA estoque;

CREATE TABLE notebook
(
    hostname      VARCHAR(11) PRIMARY KEY NOT NULL,
    patrimonio    INT (8),
    serialnumber  VARCHAR(25),
    modelo        VARCHAR(8),
    situacao      VARCHAR(10),
    numeroChamado VARCHAR(15)

);

CREATE TABLE EstoquePeriferico
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    nomeItem   VARCHAR(20),
    quantidade INT (5)
);

CREATE TABLE SaidaPeriferico
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    nomeItem      VARCHAR(20),
    numeroChamado VARCHAR(11)
);

ALTER TABLE SaidaPeriferico
    ADD CONSTRAINT FK_SaidaPeriferico_2
        foreign key (nomeItem)
            references EstoquePeriferico (nomeItem);



SELECT *
FROM estoque.notebooks;