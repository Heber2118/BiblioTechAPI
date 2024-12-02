package bibliotech.com.api.controller;

import bibliotech.com.api.dto.DadosCadastroAluno;
import bibliotech.com.api.dto.DadosLogin;
import bibliotech.com.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> fazCadastro(@RequestBody DadosCadastroAluno dados) {
        return alunoService.fazCadastro(dados);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DadosLogin dadosLogin) {
        return alunoService.fazLogin(dadosLogin);
    }

}
