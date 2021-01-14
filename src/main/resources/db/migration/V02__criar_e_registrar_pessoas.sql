CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo BOOLEAN default 1,
	logradouro VARCHAR(100),
	numero VARCHAR(10),
	complemento VARCHAR(100),
	bairro VARCHAR(30),
	cep VARCHAR(9),
	cidade VARCHAR(30),
	estado VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values 
('Hugo Vinicius', true, 'Rua Almenara', '30', 'casa', 'Sevilha A', '35620970', 'Ribeirão das Neves', 'MG'),
('Maria Luisa', true, 'Av Brasil', '30', 'casa', 'Sevilha A', '35620972', 'Belo Horizonte', 'MG'),
('Layssa Morgara', true, 'Rua Dinopolis', '30', 'casa', 'Sevilha A', '35620972', 'Betim', 'MG'),
('Joubert Jose', true, 'Rua do Fulano 1', '23', 'casa', 'Sevilha A', '35620975', 'Contagem', 'MG'),
('Jose Maria', true, 'Rua do Fulano 2', '334', 'casa', 'Sevilha A', '35620972', 'Nova Lima', 'MG'),
('Aparecida da Conceição', true, 'Rua do Beltrano 1', '235', 'casa', 'Sevilha A', '35620976', 'M', 'MG'),
('Teresinha Paixão', true, 'Rua Sem Saida', '1231', 'casa', 'Sevilha A', '35620970', 'Abaeté', 'MG'),
('Ezequiel Breno', true, 'Av. Alagoas', '235', 'casa', 'Sevilha A', '35620975', 'Ribeirão das Neves', 'MG'),
('Jeferson Reis', true, 'Av. Almenara', '2333', 'casa', 'Sevilha A', '35620970', 'Andradas', 'MG'),
('Olirio Emanuel', true, 'Av. Mone Azul', '3326', 'casa', 'Sevilha A', '35620973', 'Almeida', 'MG');
