package gestion.ventas.auto.mapper;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.Autos;
import org.springframework.stereotype.Component;

@Component
public class AutoMapper {
    public AutoDTO lisAllAutoMapper(Autos autos){
        AutoDTO autoDTO = new AutoDTO();
        autoDTO.setIdAutoDto(autos.getIdAuto());
        autoDTO.setNombreDto(autos.getNombre());
        autoDTO.setDescripcionDto(autos.getDescripcion());
        autoDTO.setMarcaDto(autos.getMarca());
        autoDTO.setModeloDto(autos.getModelo());
        autoDTO.setColorDto(autos.getColor());
        autoDTO.setAnioDto(autos.getAnio());
        autoDTO.setTipo_motorDto(autos.getTipo_motor());
        autoDTO.setCapacidadDto(autos.getCapacidad());
        autoDTO.setPrecioDto(autos.getPrecio());
        autoDTO.setSedeDto(autos.getSede());
        autoDTO.setProveedorDto(autos.getProveedor());
        autoDTO.setMantenimientoDto(autos.getMantenimiento());
        autoDTO.setFinanciamientoDto(autos.getFinanciamiento());
        autoDTO.setVentaDto(autos.getVenta());
        return autoDTO;
    }
    public Autos regisAutoMapper(AutoDTO autoDTO){
        Autos auto = new Autos();
        auto.setNombre(autoDTO.getNombreDto());
        auto.setDescripcion(autoDTO.getDescripcionDto());
        auto.setMarca(autoDTO.getMarcaDto());
        auto.setModelo(autoDTO.getModeloDto());
        auto.setColor(autoDTO.getColorDto());
        auto.setAnio(autoDTO.getAnioDto());
        auto.setTipo_motor(autoDTO.getTipo_motorDto());
        auto.setCapacidad(autoDTO.getCapacidadDto());
        auto.setPrecio(autoDTO.getPrecioDto());
        auto.setSede(autoDTO.getSedeDto());
        auto.setProveedor(autoDTO.getProveedorDto());
        auto.setMantenimiento(autoDTO.getMantenimientoDto());
        auto.setFinanciamiento(autoDTO.getFinanciamientoDto());
        auto.setVenta(autoDTO.getVentaDto());
        return auto;
    }
}
