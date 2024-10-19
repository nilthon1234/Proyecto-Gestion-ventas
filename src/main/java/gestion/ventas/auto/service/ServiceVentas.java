package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.VentasDTO;
import gestion.ventas.auto.models.Ventas;

public interface ServiceVentas {
	
	 Ventas createVenta(VentasDTO ventasDTO);

}
