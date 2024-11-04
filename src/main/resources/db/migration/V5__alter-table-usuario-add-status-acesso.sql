ALTER TABLE Usuario
    CHANGE COLUMN tipo acesso ENUM('Aluno', 'ADM') NOT NULL,
    ADD COLUMN status VARCHAR(20) DEFAULT 'Ativo';