package bibliotech.com.api.model;

import bibliotech.com.api.dto.DadosCadastroAluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "alunos")
@NoArgsConstructor
public class Aluno{

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Email")
    private String email;

    @Id
    @Column(name = "RA")
    private String ra;

    @Column(name = "Senha")
    private String senha;

    @Column(name = "curso")
    private String curso;


    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email(); // Certifique-se de que 'email' está sendo atribuído corretamente
        this.ra = dados.RA();
        this.senha = dados.senha();
        this.curso = dados.curso();
    }
}
