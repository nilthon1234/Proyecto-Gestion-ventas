package gestion.ventas.auto.dto;

import gestion.ventas.auto.models.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoDTO {

    private String idAutoDto;
    private String nombreDto;
    private String DescripcionDto;
    private String marcaDto;
    private String modeloDto;
    private String colorDto;
    private String anioDto;
    private String tipo_motorDto;
    private String capacidadDto;
    private double precioDto;
    private Sedes sedeDto;
    private Proveedores proveedorDto;
    private Mantenimiento mantenimientoDto;
    private Financiamiento financiamientoDto;
    private Ventas ventaDto;

}
