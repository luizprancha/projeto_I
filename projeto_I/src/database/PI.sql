DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;

CREATE TABLE Lojas (
  CNPJ CHAR(18) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  responsavel VARCHAR(100),
  endereco VARCHAR(150),
  telefone VARCHAR(20),
  email VARCHAR(100),
  PRIMARY KEY (CNPJ)
) ENGINE=InnoDB;

CREATE TABLE Confeccoes (
  CNPJ CHAR(18) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  responsavel VARCHAR(100),
  endereco VARCHAR(150),
  telefone VARCHAR(20),
  email VARCHAR(100),
  PRIMARY KEY (CNPJ)
) ENGINE=InnoDB;

CREATE TABLE Produtos (
  idProdutos INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  tamanho VARCHAR(20),
  cor VARCHAR(50),
  qtde_estoque INT DEFAULT 0,
  vendasSN TINYINT NOT NULL,
  precoReferencia DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (idProdutos)
) ENGINE=InnoDB;

CREATE TABLE PedidosLojas (
  idPedidosL INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  Lojas_CNPJ CHAR(18) NOT NULL,
  PRIMARY KEY (idPedidosL),
  FOREIGN KEY (Lojas_CNPJ) REFERENCES Lojas(CNPJ)
) ENGINE=InnoDB;

CREATE TABLE PedidosConfeccoes (
  idPedidoC INT NOT NULL AUTO_INCREMENT,
  data DATE NOT NULL,
  valor DECIMAL(10,2),
  Confeccoes_CNPJ CHAR(18) NOT NULL,
  forma_pgmt VARCHAR(45),
  PRIMARY KEY (idPedidoC),
  FOREIGN KEY (Confeccoes_CNPJ) REFERENCES Confeccoes(CNPJ)
) ENGINE=InnoDB;

CREATE TABLE PedidosConfeccoes_Produtos (
  PedidosConfeccoes_idPedidoC INT NOT NULL,
  Produtos_idProdutos INT NOT NULL,
  quantidade INT NOT NULL,
  preco DECIMAL(10,2),
  PRIMARY KEY (PedidosConfeccoes_idPedidoC, Produtos_idProdutos),
  FOREIGN KEY (PedidosConfeccoes_idPedidoC) REFERENCES PedidosConfeccoes(idPedidoC),
  FOREIGN KEY (Produtos_idProdutos) REFERENCES Produtos(idProdutos)
) ENGINE=InnoDB;

CREATE TABLE PedidosLojas_Produtos (
  PedidosLojas_idPedidosL INT NOT NULL,
  Produtos_idProdutos INT NOT NULL,
  preco DECIMAL(10,2),
  quantidade INT,
  PRIMARY KEY (PedidosLojas_idPedidosL, Produtos_idProdutos),
  FOREIGN KEY (PedidosLojas_idPedidosL) REFERENCES PedidosLojas(idPedidosL),
  FOREIGN KEY (Produtos_idProdutos) REFERENCES Produtos(idProdutos)
) ENGINE=InnoDB;

INSERT INTO Lojas VALUES
('00.111.222/0001-10', 'Loja Estilo Fashion', 'Marcos Silva', 'Rua A, 100', '51999990001', 'contato@estilo.com'),
('11.222.333/0001-20', 'Moda Center', 'Ana Pereira', 'Rua B, 200', '51988880002', 'vendas@modacenter.com'),
('22.333.444/0001-30', 'Trendy Store', 'Carlos Souza', 'Rua C, 300', '51977770003', 'trendy@store.com');

INSERT INTO Confeccoes VALUES
('55.666.777/0001-40', 'Confecção Alfa', 'João Mendes', 'Av Brasil, 500', '51966660001', 'alfa@conf.com'),
('66.777.888/0001-50', 'Confecção Beta', 'Julia Castro', 'Av Central, 600', '51955550002', 'beta@conf.com'),
('77.888.999/0001-60', 'Confecção Gamma', 'Pedro Rodrigues', 'Av Sul, 700', '51944440003', 'gamma@conf.com');

INSERT INTO Produtos (nome, tamanho, cor, qtde_estoque, vendasSN, precoReferencia) VALUES
('Camiseta Básica', 'M', 'Branca', 150, 1, 39.90),
('Calça Jeans', '42', 'Azul', 80, 1, 119.90),
('Moletom Unissex', 'G', 'Preto', 60, 0, 149.90);

INSERT INTO PedidosLojas (data, valor_total, Lojas_CNPJ) VALUES
('2025-01-10', 450.00, '00.111.222/0001-10'),
('2025-01-12', 799.90, '11.222.333/0001-20'),
('2025-01-15', 359.70, '22.333.444/0001-30');

INSERT INTO PedidosConfeccoes (data, valor, Confeccoes_CNPJ, forma_pgmt) VALUES
('2025-01-05', 1200.00, '55.666.777/0001-40', 'Pix'),
('2025-01-07', 1850.50, '66.777.888/0001-50', 'Boleto'),
('2025-01-09', 980.90, '77.888.999/0001-60', 'Cartão');

INSERT INTO PedidosLojas_Produtos VALUES
(1, 1, 39.90, 5),
(2, 2, 119.90, 4),
(3, 3, 149.90, 2);

INSERT INTO PedidosConfeccoes_Produtos VALUES
(1, 1, 30, 25.00),
(2, 2, 50, 70.00),
(3, 3, 20, 90.00);
