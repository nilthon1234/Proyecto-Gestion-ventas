package gestion.ventas.auto.dto;

import java.time.LocalDateTime;

import gestion.ventas.auto.models.Clientes;
import gestion.ventas.auto.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentasDTO {
	
	private Integer idVenta;          
    private String numeroVenta;          
    private LocalDateTime fechaVenta;    
    private Clientes cliente;            
    private Usuario usuario;             

}
