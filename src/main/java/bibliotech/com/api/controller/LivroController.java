package bibliotech.com.api.controller;
import bibliotech.com.api.model.Aluno;
import bibliotech.com.api.model.Emprestimo;
import bibliotech.com.api.model.Livro;
import bibliotech.com.api.repository.AdmRepository;
import bibliotech.com.api.repository.AlunoRepository;
import bibliotech.com.api.repository.EmprestimoRepository;
import bibliotech.com.api.repository.LivroRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import java.util.Date;



@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroRepository livroRepository;
    private EmprestimoRepository emprestimoRepository;
    private AlunoRepository alunoRepository;
    private AdmRepository admRepository;

    public LivroController(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository,
                           AlunoRepository alunoRepository, AdmRepository admRepository) {
        this.livroRepository = livroRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.alunoRepository = alunoRepository;
        this.admRepository = admRepository;
    }

    @PostMapping("/cadastrar")
    public String cadastrarLivro(@RequestBody Livro livro) {
        try {

            livroRepository.save(livro);


            String raAluno = "RA_DO_ALUNO";
            Aluno aluno = alunoRepository.findByRa(raAluno);
            int idAdm = 1;

            if (aluno == null) {
                return "Aluno não encontrado.";
            }

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setRaAluno(raAluno);
            emprestimo.setIdLivro(livro.getIdLivro());
            emprestimo.setIdAdm(idAdm);
            emprestimo.setDataInicio(new Date());
            emprestimo.setDataFim(null);
            emprestimo.setDataDevolucao(null);


            emprestimoRepository.save(emprestimo);

            return "Livro cadastrado e empréstimo associado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar livro: " + e.getMessage();
        }
    }
}