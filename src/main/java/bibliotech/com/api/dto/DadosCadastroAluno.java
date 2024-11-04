package bibliotech.com.api.dto;

import bibliotech.com.api.enums.Acesso;

public record DadosCadastroAluno(String nome, String email, String RA,
                                 String senha, Acesso acesso) {
    public DadosCadastroAluno(String nome, String email, String RA, String senha) {
        this(nome, email, RA, senha, Acesso.Aluno); //utilizei aqui uma técnica chamada overloading que
        // visa criar um construtor adicional
        // em um record para definir valores fixos para variáveis específicas (o acesso, no caso)
    }
}
