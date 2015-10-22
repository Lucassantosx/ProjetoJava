-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22-Out-2015 às 20:43
-- Versão do servidor: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `livraria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(9) NOT NULL,
  `nome` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `identidade` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `cpf` varchar(14) COLLATE latin1_spanish_ci NOT NULL,
  `endereco` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `telefone` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nome`, `identidade`, `cpf`, `endereco`, `telefone`, `email`) VALUES
(1, 'Celson Rodrigues', '221425', '241456', 'rua dos sonhos', '36363636', 'celsonrd@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE IF NOT EXISTS `editora` (
  `id_editora` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `editora`
--

INSERT INTO `editora` (`id_editora`, `nome`, `endereco`, `telefone`) VALUES
(1, 'Editora do poder', 'rualfjasfl', '156516'),
(2, 'Editora Camarada', 'dafsfaf', 'fafasf65116');

-- --------------------------------------------------------

--
-- Estrutura da tabela `escritor`
--

CREATE TABLE IF NOT EXISTS `escritor` (
  `id_escritor` int(11) NOT NULL,
  `nome` varchar(100) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Extraindo dados da tabela `escritor`
--

INSERT INTO `escritor` (`id_escritor`, `nome`) VALUES
(1, 'Linux Torvalds'),
(2, 'Tio Bill Gates'),
(3, 'Steve (mega) Jobs'),
(4, 'Morpheus');

-- --------------------------------------------------------

--
-- Estrutura da tabela `escritor_livro`
--

CREATE TABLE IF NOT EXISTS `escritor_livro` (
  `id_escritor` int(11) NOT NULL,
  `id_livro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `escritor_livro`
--

INSERT INTO `escritor_livro` (`id_escritor`, `id_livro`) VALUES
(2, 1),
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `forma_pgto`
--

CREATE TABLE IF NOT EXISTS `forma_pgto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Extraindo dados da tabela `forma_pgto`
--

INSERT INTO `forma_pgto` (`id`, `descricao`) VALUES
(1, 'Dinheiro (Espécie)'),
(2, 'Cartão de Crédito'),
(3, 'Cartão de Débito'),
(4, 'Cheque Pré datado'),
(5, 'Carnê');

-- --------------------------------------------------------

--
-- Estrutura da tabela `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `id_genero` int(11) NOT NULL,
  `descricao` varchar(200) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Extraindo dados da tabela `genero`
--

INSERT INTO `genero` (`id_genero`, `descricao`) VALUES
(1, 'Romance'),
(2, 'Sci-fi'),
(3, 'Drama'),
(4, 'Comédia'),
(5, 'Aventura'),
(6, 'Mitologia'),
(7, 'Auto ajuda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE IF NOT EXISTS `livro` (
  `id_livro` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `id_editora` int(10) NOT NULL,
  `id_genero` int(10) NOT NULL,
  `preco` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livro`
--

INSERT INTO `livro` (`id_livro`, `titulo`, `id_editora`, `id_genero`, `preco`) VALUES
(1, 'A fantastica Fábrica de chocolate', 1, 2, 25.54);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `id_venda` int(10) NOT NULL,
  `data` varchar(20) NOT NULL,
  `cod_cliente` int(10) NOT NULL,
  `cod_vendedor` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`id_venda`, `data`, `cod_cliente`, `cod_vendedor`) VALUES
(1, '', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_produto`
--

CREATE TABLE IF NOT EXISTS `venda_produto` (
  `id_venda_prod` int(11) NOT NULL,
  `id_venda` int(10) NOT NULL,
  `id_livro` int(10) NOT NULL,
  `quantidade` int(3) NOT NULL,
  `preco` float NOT NULL,
  `valor_total` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda_produto`
--

INSERT INTO `venda_produto` (`id_venda_prod`, `id_venda`, `id_livro`, `quantidade`, `preco`, `valor_total`) VALUES
(1, 1, 1, 3, 10, 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE IF NOT EXISTS `vendedor` (
  `matricula_vendedor` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendedor`
--

INSERT INTO `vendedor` (`matricula_vendedor`, `nome`, `cpf`, `telefone`) VALUES
(1, 'Robert Deniro', '1234156', '81818181'),
(2, 'Eduard Snolder', '454654654', '5544453'),
(3, 'Robin Wilians', '554455', '654444'),
(4, 'Chris Rock', '4654465', '546454456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indexes for table `editora`
--
ALTER TABLE `editora`
  ADD PRIMARY KEY (`id_editora`);

--
-- Indexes for table `escritor`
--
ALTER TABLE `escritor`
  ADD PRIMARY KEY (`id_escritor`);

--
-- Indexes for table `forma_pgto`
--
ALTER TABLE `forma_pgto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`),
  ADD UNIQUE KEY `id_genero` (`id_genero`);

--
-- Indexes for table `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`id_livro`),
  ADD KEY `id_editora` (`id_editora`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`id_venda`);

--
-- Indexes for table `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD PRIMARY KEY (`id_venda_prod`);

--
-- Indexes for table `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`matricula_vendedor`),
  ADD UNIQUE KEY `matricula_vendedor` (`matricula_vendedor`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(9) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `editora`
--
ALTER TABLE `editora`
  MODIFY `id_editora` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `escritor`
--
ALTER TABLE `escritor`
  MODIFY `id_escritor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `forma_pgto`
--
ALTER TABLE `forma_pgto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `livro`
--
ALTER TABLE `livro`
  MODIFY `id_livro` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `id_venda` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `venda_produto`
--
ALTER TABLE `venda_produto`
  MODIFY `id_venda_prod` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `vendedor`
--
ALTER TABLE `vendedor`
  MODIFY `matricula_vendedor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
