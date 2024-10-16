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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    
    private String nombre;
    
    private String apellido;
    
    @Column(length = 9)
    private String celular;
    
    @Column(name = "nombreUsuario", length = 4, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "contraseña", length = 4, nullable = false)
    private String contraseña;
}

	
	



