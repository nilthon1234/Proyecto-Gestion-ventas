package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedores")
    private Integer idProveedor;
}
