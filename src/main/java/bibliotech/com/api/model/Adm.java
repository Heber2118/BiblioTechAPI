package bibliotech.com.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "adm")
public class Adm{
    @Id
    @Getter @Setter
    private int idAdm;
    @Getter @Setter
    private String nome;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String senha;
    @Getter @Setter
    private String cargo;

}
