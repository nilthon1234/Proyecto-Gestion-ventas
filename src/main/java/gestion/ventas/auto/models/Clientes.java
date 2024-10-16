package gestion.ventas.auto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
