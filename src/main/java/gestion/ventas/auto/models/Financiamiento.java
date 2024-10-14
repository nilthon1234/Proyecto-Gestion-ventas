package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Financiamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_financiamiento")
    private Integer idFinaciamiento;
}
