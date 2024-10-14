package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Sedes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Integer idSede;

}
