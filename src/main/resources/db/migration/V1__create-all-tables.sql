CREATE TABLE Alunos (
    RA VARCHAR(255) PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    Curso VARCHAR(255) NOT NULL
);

CREATE TABLE ADM (
    IdADM INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Senha VARCHAR(255) NOT NULL,
    Cargo VARCHAR(100)
);

CREATE TABLE Livro (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(200) NOT NULL,
    Autor VARCHAR(100),
    Genero VARCHAR(100),
    Estoque INT NOT NULL CHECK (Estoque >= 0)
);

CREATE TABLE Emprestimo (
    IdEmprestimo INT AUTO_INCREMENT PRIMARY KEY,
    RA VARCHAR(255) NOT NULL, -- Alterado para VARCHAR(255) para combinar com a tabela Alunos
    id_livro INT NOT NULL,
    IdADM INT, -- Adicionando o administrador responsável
    DataInicio DATE NOT NULL,
    DataFim DATE NOT NULL,
    DataDevolucao DATE,
    FOREIGN KEY (RA) REFERENCES Alunos(RA),
    FOREIGN KEY (id_livro) REFERENCES Livro(id_livro),
    FOREIGN KEY (IdADM) REFERENCES ADM(IdADM) -- Relacionamento com a tabela ADM
);

CREATE TABLE Multa (
    IdMulta INT AUTO_INCREMENT PRIMARY KEY,
    IdEmprestimo INT NOT NULL,
    Valor DECIMAL(10, 2) NOT NULL,
    Status ENUM('pendente', 'paga') DEFAULT 'pendente',
    DataPagamento DATE,
    FOREIGN KEY (IdEmprestimo) REFERENCES Emprestimo(IdEmprestimo)
);
