CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ra VARCHAR(20),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    tipo ENUM('Aluno', 'ADM') NOT NULL
);

CREATE TABLE Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    autor VARCHAR(50),
    estoque INT DEFAULT 0
);

CREATE TABLE Emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_livro INT,
    data_inicio DATE NOT NULL,
    data_fim DATE,
    multa DOUBLE DEFAULT 0,
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    FOREIGN KEY (id_livro) REFERENCES Livro(id)
);

CREATE TABLE Multa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_emprestimo INT,
    valor DOUBLE NOT NULL,
    FOREIGN KEY (id_emprestimo) REFERENCES Emprestimo(id)
);
