package bibliotech.com.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADM")
public class Adm extends Usuario {

    public Adm(String nome, String email, String senha) {
        super(nome, email, senha);  // Agora não passamos o 'acesso'
    }
}
