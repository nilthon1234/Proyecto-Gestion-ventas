package gestion.ventas.auto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {
    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String celular;
    private String correo;
    private Integer idDocumento;
}
