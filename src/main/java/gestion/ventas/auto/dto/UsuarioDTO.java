package gestion.ventas.auto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private int idUsuario;           
    private String nombre;           
    private String apellido;       
    private String celular;         
    private String username;
    private String password;
    private int documento; 
    private int sede;      
    private int rol;      

}
