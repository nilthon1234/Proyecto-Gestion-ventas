package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Mantenimiento;
import gestion.ventas.auto.repository.IMantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceMantenimientoImpl implements ServiceMantenimiento {

    @Autowired
    private IMantenimientoRepository repository;

    @Override
    public Mantenimiento crearMantenimiento(Mantenimiento mantenimiento) {
        return repository.save(mantenimiento);
    }

    @Override
    public Mantenimiento updateMantenimiento(Integer id, Mantenimiento mantenimiento) {
        mantenimiento.setIdMantemiento(id);
        return repository.findById(id)
                .map(m -> repository.save(mantenimiento))
                .orElse(null);
    }

    @Override
    public List<Mantenimiento> findByNombreOrRangeDate(String nombre, LocalDate start, LocalDate end) {
        return repository.findByNombreOrRangeDate(nombre, start, end);
    }
}
