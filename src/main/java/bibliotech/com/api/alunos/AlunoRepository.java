package bibliotech.com.api.alunos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    Aluno findByRA(String RA);
}
