package bibliotech.com.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Getter
@Setter
@Table(name = "livro")
public class Livro {

    @Getter @Id @Column(name = "IdLivro")
    private int idLivro;
    @Getter @Setter
    private String titulo;
    @Getter @Setter
    private String autor;
    @Getter @Setter
    private String genero;
    @Getter @Setter
    private int estoque;


}
