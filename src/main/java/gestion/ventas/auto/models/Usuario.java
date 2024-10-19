package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")  // Nombre de la tabla en la base de datos
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;
    
    private String nombre;
    
    private String apellido;
    
    @Column(length = 9)
    private String celular;  // Cambiado a String para mantener la longitud y evitar problemas con los números
    
    @Column(name = "nombreUsuario", length = 4, nullable = false)
    private String nombreUsuario;
    
    @Column(name = "contraseña", length = 4, nullable = false)
    private String contraseña;
    
    @ManyToOne // Asumiendo que 'documento', 'sede' y 'rol' son entidades relacionadas
    @JoinColumn(name = "documento")
    private Documento documento; // Clase Documento que debes crear
    
    @ManyToOne
    @JoinColumn(name = "sede")
    private Sedes sede; // Clase Sede que debes crear
    
    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol; // Clase Rol que debes crear
}
