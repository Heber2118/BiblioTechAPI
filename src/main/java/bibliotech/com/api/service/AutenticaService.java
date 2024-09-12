package bibliotech.com.api.service;

import bibliotech.com.api.alunos.Aluno;
import bibliotech.com.api.alunos.AlunoRepository;
import bibliotech.com.api.alunos.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AutenticaService {

    @Autowired
    AlunoRepository alunoRepository;

    public DadosCadastroAluno fazLogin(String RA, String senha) {
        Aluno aluno = alunoRepository.findByRA(RA); // Buscar o aluno pelo RA

        if (aluno == null) {
            throw new AuthenticationException("Aluno não encontrado com o RA: " + RA) {};
        }

        if (senha.equals(aluno.getSenha())) {
            return new DadosCadastroAluno(aluno.getRA(),
                    aluno.getNome(),
                    aluno.getSenha(),
                    aluno.getEmail());
        } else {
            throw new AuthenticationException("Senha ou RA incorretos.") {};
        }
    }
}
