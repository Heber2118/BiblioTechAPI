package bibliotech.com.api.controller;

import bibliotech.com.api.alunos.Aluno;
import bibliotech.com.api.alunos.AlunoRepository;
import bibliotech.com.api.alunos.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public void cadastraAluno(@RequestBody DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){

    var aluno = new Aluno(dados);
    alunoRepository.save(aluno);

        var uri = uriBuilder.path("/pacientes {id}").buildAndExpand(aluno.getId()).toUri();


    }

    @GetMapping
    public ResponseEntity<Page<Aluno>> listarAluno(Pageable paginacao) {
        Page<Aluno> alunos = alunoRepository.findAll(paginacao);
        return ResponseEntity.ok(alunos);
    }

}
