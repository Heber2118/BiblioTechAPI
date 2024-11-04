package bibliotech.com.api.service;

import bibliotech.com.api.model.Aluno;
import bibliotech.com.api.repository.AlunoRepository;
import bibliotech.com.api.dto.DadosCadastroAluno;
import bibliotech.com.api.enums.Acesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity<?> fazCadastro(DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
        var aluno = new Aluno(dados);
        alunoRepository.save(aluno);
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(Map.of("success", true));
    }

    public DadosCadastroAluno fazLogin(String RA, String senha) {
        Aluno aluno = alunoRepository.findByRA(RA);

        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado com o RA: " + RA); // Exceção customizada
        }

        if (senha.equals(aluno.getSenha())) {
            return new DadosCadastroAluno(aluno.getNome(), aluno.getEmail(), aluno.getRA(), aluno.getSenha());
        } else {
            throw new IllegalArgumentException("Senha ou RA incorretos.");
        }
    }
}
