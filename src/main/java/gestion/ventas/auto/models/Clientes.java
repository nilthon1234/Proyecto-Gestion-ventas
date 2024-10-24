package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Clientes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Column(name = "nombre", length = 500)
    private String nombre;

    @Column(name = "apellido", length = 500)
    private String apellido;

    @Column(name = "direccion", length = 500)
    private String direccion;

    @Column(name = "celular", length = 9)
    private String celular;

    @Column(name = "correo", length = 500)
    private String correo;
}
