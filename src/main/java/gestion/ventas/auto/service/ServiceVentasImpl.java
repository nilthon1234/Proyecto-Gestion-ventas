package gestion.ventas.auto.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gestion.ventas.auto.models.Ventas;
import gestion.ventas.auto.repository.VentasRepository;



@Service
public class ServiceVentasImpl implements ServiceVentas {
	
	@Autowired
    private VentasRepository ventasRepository;

 
	@Override
	public Ventas createVenta(Ventas ventas) {
		// TODO Auto-generated method stub
		return ventasRepository.save(ventas);
	}
}