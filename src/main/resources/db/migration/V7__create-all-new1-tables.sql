CREATE TABLE Usuarios (
    id VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo_usuario ENUM('Aluno', 'ADM')
);
CREATE TABLE Alunos (
    ra VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    id_usuario VARCHAR(50),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);
CREATE TABLE ADM (
    id VARCHAR(50) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    id_usuario VARCHAR(50),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);
CREATE TABLE Livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    categoria VARCHAR(100),
    estoque INT CHECK (estoque >= 0)
);
CREATE TABLE Emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario VARCHAR(50),
    id_livro INT,
    DataInicio DATE,
    DataFim DATE,
    DataDevolucao DATE,
    multa DOUBLE DEFAULT 0.00,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id),
    FOREIGN KEY (id_livro) REFERENCES Livros(id)
);
CREATE TABLE Multas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario VARCHAR(50),
    valor DOUBLE,
    status ENUM('pendente', 'paga') DEFAULT 'pendente',
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);
