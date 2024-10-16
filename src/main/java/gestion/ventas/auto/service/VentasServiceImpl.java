package gestion.ventas.auto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestion.ventas.auto.models.Ventas;
import gestion.ventas.auto.repository.VentasRepository;

@Service
public class VentasServiceImpl implements VentasService {
    private final VentasRepository ventasRepository;

    public VentasServiceImpl(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> listAll() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas createVenta(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateVenta(int id, Ventas ventas) {
        ventas.setIdVenta(id); // Asignar el ID para la actualización
        return ventasRepository.save(ventas);
    }

    @Override
    public void deleteVenta(int id) {
        ventasRepository.deleteById(id);
    }
}