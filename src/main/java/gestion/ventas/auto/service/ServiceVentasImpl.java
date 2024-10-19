package gestion.ventas.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.ventas.auto.dto.VentasDTO;
import gestion.ventas.auto.models.Ventas;
import gestion.ventas.auto.repository.VentasRepository;

@Service
public class ServiceVentasImpl implements ServiceVentas {
	
	@Autowired
    private VentasRepository ventasRepository;

    @Override
    public Ventas createVenta(VentasDTO ventasDTO) {
        Ventas venta = new Ventas();
        venta.setNumeroVenta(ventasDTO.getNumeroVenta());
        venta.setFechaVenta(ventasDTO.getFechaVenta() != null ? ventasDTO.getFechaVenta() : java.time.LocalDateTime.now());
        venta.setCliente(ventasDTO.getCliente());
        venta.setUsuario(ventasDTO.getUsuario());
        return ventasRepository.save(venta);
    }
}