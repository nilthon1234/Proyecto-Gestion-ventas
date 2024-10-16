package gestion.ventas.auto.mapper;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.*;
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
        autoDTO.setSedeDto(autos.getSede().getIdSede());
        autoDTO.setProveedorDto(autos.getProveedor().getIdProveedor());
        autoDTO.setMantenimientoDto(autos.getMantenimiento().getIdMantemiento());
        autoDTO.setFinanciamientoDto(autos.getFinanciamiento().getIdFinaciamiento());
        autoDTO.setVentaDto(autos.getVenta().getIdVenta());
        return autoDTO;
    }
    public AutoDTO regisAutoMapper(Autos autos){
        return new AutoDTO(
                autos.getIdAuto(),
                autos.getNombre(),
                autos.getDescripcion(),
                autos.getMarca(),
                autos.getModelo(),
                autos.getColor(),
                autos.getAnio(),
                autos.getTipo_motor(),
                autos.getCapacidad(),
                autos.getPrecio(),
                autos.getSede().getIdSede(),
                autos.getProveedor().getIdProveedor(),
                autos.getMantenimiento().getIdMantemiento(),
                autos.getFinanciamiento().getIdFinaciamiento(),
                autos.getVenta().getIdVenta()
        );
    }
    public Autos updateAuto(AutoDTO autoDTO, Autos autos){
        Sedes sd = new Sedes();
        sd.setIdSede(autoDTO.getSedeDto());
        Proveedores pd = new Proveedores();
        pd.setIdProveedor(autoDTO.getProveedorDto());
        Mantenimiento mn =  new Mantenimiento();
        mn.setIdMantemiento(autoDTO.getMantenimientoDto());
        Financiamiento fm = new Financiamiento();
        fm.setIdFinaciamiento(autoDTO.getFinanciamientoDto());
        Ventas v = new Ventas();
        v.setIdVenta(autoDTO.getVentaDto());

        autos.setNombre(autoDTO.getNombreDto());
        autos.setDescripcion(autoDTO.getDescripcionDto());
        autos.setMarca(autoDTO.getMarcaDto());
        autos.setModelo(autoDTO.getModeloDto());
        autos.setColor(autoDTO.getColorDto());
        autos.setAnio(autoDTO.getAnioDto());
        autos.setTipo_motor(autoDTO.getTipo_motorDto());
        autos.setCapacidad(autoDTO.getCapacidadDto());
        autos.setPrecio(autoDTO.getPrecioDto());
        autos.setSede(sd);
        autos.setProveedor(pd);
        autos.setMantenimiento(mn);
        autos.setFinanciamiento(fm);
        autos.setVenta(v);
        return autos;
    }
}
