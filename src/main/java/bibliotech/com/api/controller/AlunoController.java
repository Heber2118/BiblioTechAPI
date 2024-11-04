package bibliotech.com.api.controller;

import bibliotech.com.api.dto.DadosCadastroAluno;
import bibliotech.com.api.dto.DadosLogin;
import bibliotech.com.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoService alunoService; // Chama a camada de serviço

    @PostMapping(value = "/cadastrar", consumes = "application/json")
    @Transactional
    public ResponseEntity<?> cadastraAluno(@RequestBody DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
        return alunoService.fazCadastro(dados, uriBuilder); // Chama o método da AlunoService
    }

//    @GetMapping
//    public ResponseEntity<Page<Aluno>> listarAluno(Pageable paginacao) {
//        Page<Aluno> alunos = alunoService.listarAlunos(paginacao); // Método a ser implementado na AlunoService
//        return ResponseEntity.ok(alunos);
//    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> fazLogin(@RequestBody DadosLogin dadosLogin) {
        try {
            // Chama o método de login passando RA e senha
            DadosCadastroAluno aluno = alunoService.fazLogin(dadosLogin.RA(), dadosLogin.senha());
            return ResponseEntity.ok(aluno);
        } catch (IllegalArgumentException e) {
            // Retorna uma resposta de erro se o login falhar
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
