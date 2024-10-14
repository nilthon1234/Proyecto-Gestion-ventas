package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private Integer idVenta;
}
