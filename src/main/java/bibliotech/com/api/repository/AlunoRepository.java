package bibliotech.com.api.repository;

import bibliotech.com.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    Aluno findByRA(String RA);
}
