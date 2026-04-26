DROP DATABASE IF EXISTS mydb;
CREATE DATABASE mydb;
USE mydb;

CREATE TABLE Usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50),
  usuario VARCHAR(50),
  cargo VARCHAR(20),
  senha VARCHAR(20)
) ENGINE=InnoDB;

CREATE TABLE Produtos (
  idProdutos INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  tamanho VARCHAR(20),
  cor VARCHAR(50),
  qtde_estoque INT DEFAULT 0,
  vendasSN TINYINT NOT NULL,
  preco DECIMAL(10,2) NOT NULL,
  tipo_produto VARCHAR(50)
) ENGINE=InnoDB;

CREATE TABLE Confeccoes (
  idConfeccoes INT AUTO_INCREMENT PRIMARY KEY,
  CNPJ CHAR(18) NOT NULL UNIQUE,
  nome VARCHAR(100) NOT NULL,
  responsavel VARCHAR(100),
  endereco VARCHAR(150),
  telefone VARCHAR(20),
  email VARCHAR(100)
) ENGINE=InnoDB;

CREATE TABLE Lojas (
  idLoja INT AUTO_INCREMENT PRIMARY KEY,
  CNPJ CHAR(18) NOT NULL UNIQUE,
  nome VARCHAR(100) NOT NULL,
  responsavel VARCHAR(100),
  endereco VARCHAR(150),
  telefone VARCHAR(20),
  email VARCHAR(100)
) ENGINE=InnoDB;

CREATE TABLE PedidosLojas (
  idPedidosL INT AUTO_INCREMENT PRIMARY KEY,
  data_entrega DATE NOT NULL,
  valor_total DECIMAL(10,2) NOT NULL,
  Lojas_CNPJ CHAR(18) NOT NULL,
  endereco VARCHAR(50) NOT NULL,
  FOREIGN KEY (Lojas_CNPJ) REFERENCES Lojas(CNPJ)
) ENGINE=InnoDB;

CREATE TABLE PedidosConfeccoes (
  idPedidoC INT AUTO_INCREMENT PRIMARY KEY,
  entrega DATE NOT NULL,
  valor DECIMAL(10,2),
  Confeccoes_CNPJ CHAR(18) NOT NULL,
  forma_pgmt VARCHAR(45),
  FOREIGN KEY (Confeccoes_CNPJ) REFERENCES Confeccoes(CNPJ)
) ENGINE=InnoDB;

CREATE TABLE PedidosConfeccoes_Produtos (
  PedidosConfeccoes_idPedidoC INT,
  Produtos_idProdutos INT,
  quantidade INT NOT NULL,
  preco DECIMAL(10,2),
  PRIMARY KEY (PedidosConfeccoes_idPedidoC, Produtos_idProdutos),
  FOREIGN KEY (PedidosConfeccoes_idPedidoC) REFERENCES PedidosConfeccoes(idPedidoC),
  FOREIGN KEY (Produtos_idProdutos) REFERENCES Produtos(idProdutos)
) ENGINE=InnoDB;

CREATE TABLE PedidosLojas_Produtos (
  PedidosLojas_idPedidosL INT,
  Produtos_idProdutos INT,
  preco DECIMAL(10,2),
  quantidade INT,
  PRIMARY KEY (PedidosLojas_idPedidosL, Produtos_idProdutos),
  FOREIGN KEY (PedidosLojas_idPedidosL) REFERENCES PedidosLojas(idPedidosL),
  FOREIGN KEY (Produtos_idProdutos) REFERENCES Produtos(idProdutos)
) ENGINE=InnoDB;

INSERT INTO Usuarios VALUES
(null, "Maria Clara Oliveira", "maria_clara", "Auxiliar de compras", "abcd"),
(null,"João Batiste Silva", "silva.batista", "Almoxarife", "Joao_@.2008"),
(null,"Maicon Douglas", "maicon2000", "Limpeza", "123456789");

INSERT INTO Produtos (nome, tamanho, cor, qtde_estoque, vendasSN, preco) VALUES
('Camiseta Básica', 'M', 'Branca', 150, 1, 39.90),
('Calça Jeans', '42', 'Azul', 80, 1, 119.90),
('Moletom Unissex', 'G', 'Preto', 60, 0, 149.90);

INSERT INTO Confeccoes (CNPJ, nome, responsavel, endereco, telefone, email) VALUES
('55.666.777/0001-40', 'Confecção Alfa', 'João Mendes', 'Av Brasil, 500', '51966660001', 'alfa@conf.com'),
('66.777.888/0001-50', 'Confecção Beta', 'Julia Castro', 'Av Central, 600', '51955550002', 'beta@conf.com'),
('77.888.999/0001-60', 'Confecção Gamma', 'Pedro Rodrigues', 'Av Sul, 700', '51944440003', 'gamma@conf.com');

INSERT INTO Lojas (CNPJ, nome, responsavel, endereco, telefone, email) VALUES
('00.111.222/0001-10', 'Loja Estilo Fashion', 'Marcos Silva', 'Rua A, 100', '51999990001', 'contato@estilo.com'),
('11.222.333/0001-20', 'Moda Center', 'Ana Pereira', 'Rua B, 200', '51988880002', 'vendas@modacenter.com'),
('22.333.444/0001-30', 'Trendy Store', 'Carlos Souza', 'Rua C, 300', '51977770003', 'trendy@store.com');

INSERT INTO PedidosLojas (data_entrega, valor_total, endereco, Lojas_CNPJ) VALUES
('2025-01-10', 450.00, 'Rua D,101' ,'00.111.222/0001-10'),
('2025-01-12', 799.90, 'Rua E, 200', '11.222.333/0001-20'),
('2025-01-15', 359.70, 'Rua F, 300', '22.333.444/0001-30');

INSERT INTO PedidosConfeccoes (entrega, valor, Confeccoes_CNPJ, forma_pgmt) VALUES
('2025-01-05', 1200.00, '55.666.777/0001-40', 'Pix'),
('2025-01-07', 1850.50, '66.777.888/0001-50', 'Boleto'),
('2025-01-09', 980.90, '77.888.999/0001-60', 'Cartão');