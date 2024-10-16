package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantemiento;

}
