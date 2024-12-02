package bibliotech.com.api.repository;

import bibliotech.com.api.model.Aluno;
import bibliotech.com.api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
