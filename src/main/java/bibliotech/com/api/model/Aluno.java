package bibliotech.com.api.model;

import bibliotech.com.api.dto.DadosCadastroAluno;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Aluno")
@NoArgsConstructor
public class Aluno extends Usuario {

    @Column(name = "ra")
    @Getter
    private String RA;

    public Aluno(DadosCadastroAluno dados) {
        this.RA = dados.RA();
    }
}
