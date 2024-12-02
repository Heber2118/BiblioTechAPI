package bibliotech.com.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "emprestimos")
public class Emprestimo {

    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmprestimo;
    @Getter @Setter
    private String raAluno;
    @Getter @Setter @Column(name="IdLivro")
    private int idLivro;
    @Getter @Setter
    private int idAdm;
    @Getter @Setter
    private Date dataInicio;
    @Getter @Setter
    private Date dataFim;
    @Getter @Setter
    private Date dataDevolucao;

}
