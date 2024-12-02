package bibliotech.com.api.repository;

import bibliotech.com.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Aluno findByRa(String ra); // Método para buscar aluno pelo RA
}
