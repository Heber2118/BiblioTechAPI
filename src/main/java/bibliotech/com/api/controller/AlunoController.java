package bibliotech.com.api.controller;

import bibliotech.com.api.alunos.Aluno;
import bibliotech.com.api.alunos.AlunoRepository;
import bibliotech.com.api.alunos.DadosCadastroAluno;
import bibliotech.com.api.dto.dadosLogin;
import bibliotech.com.api.service.AutenticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private AutenticaService autenticaService;

//    @PostMapping("/cadastrar")
//    @Transactional
//    public void cadastraAluno(@RequestBody DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
//    var aluno = new Aluno(dados);
//    alunoRepository.save(aluno);
//        var uri = uriBuilder.path("/alunos {id}").buildAndExpand(aluno.getId()).toUri();
//    }

    @PostMapping(value = "/cadastrar", consumes = "application/json")
    @Transactional
    public ResponseEntity<?> cadastraAluno(@RequestBody DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
        var aluno = new Aluno(dados);
        alunoRepository.save(aluno);
        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(Map.of("success", true));
    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> listarAluno(Pageable paginacao) {
        Page<Aluno> alunos = alunoRepository.findAll(paginacao);
        return ResponseEntity.ok(alunos);
    }

    @PostMapping("/login")
    @Transactional
   public ResponseEntity<?> fazLogin(@RequestBody dadosLogin dadosLogin){
        try{
            DadosCadastroAluno aluno = autenticaService.fazLogin(dadosLogin.RA(), dadosLogin.senha());
            return ResponseEntity.ok(Map.of("success", true));
        }
        catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false));
        }
    }



}
