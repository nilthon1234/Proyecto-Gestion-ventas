package gestion.ventas.auto.service;

import java.util.List;

import gestion.ventas.auto.models.Ventas;

public interface VentasService {
	
	List<Ventas> listAll();
    Ventas createVenta(Ventas ventas);
    Ventas updateVenta(int id, Ventas ventas);
    void deleteVenta(int id);

}
