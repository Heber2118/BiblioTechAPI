package bibliotech.com.api.service;

import bibliotech.com.api.dto.DadosLogin;
import bibliotech.com.api.model.Aluno;
import bibliotech.com.api.repository.AlunoRepository;
import bibliotech.com.api.dto.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public ResponseEntity<?> fazCadastro(DadosCadastroAluno dados) {

        System.out.println("Dados recebidos: " + dados);

        Aluno aluno = new Aluno(dados);

//        // Atribui manualmente o RA, caso seja necessário (verifique sua lógica de geração de RA)
//        if (aluno.getRa() == null || aluno.getRa().isEmpty()) {
//            throw new IllegalArgumentException("RA não pode ser vazio");
//        }

        alunoRepository.save(aluno);  // Salva no banco

        // Retorna apenas o sucesso como esperado pelo front-end
        return ResponseEntity.ok(Map.of("success", true));
    }

    public ResponseEntity<?> fazLogin(DadosLogin dadosLogin ) {

        Aluno aluno = alunoRepository.findByRa(dadosLogin.RA());
        if (aluno == null) {
            return ResponseEntity.status(404).body(Map.of("error", "RA não encontrado"));
        }
        if (!aluno.getSenha().equals(dadosLogin.senha())) {
            return ResponseEntity.status(401).body(Map.of("error", "Senha incorreta"));
        }
        // Cria um mapa com os dados do aluno
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Aluno cadastrado com sucesso!");
        response.put("nome", aluno.getNome());
        response.put("email", aluno.getEmail());
        response.put("ra", aluno.getRa());
        response.put("curso", aluno.getCurso());

        // Retorna o mapa no ResponseEntity
        return ResponseEntity.ok(response);

    }
}

