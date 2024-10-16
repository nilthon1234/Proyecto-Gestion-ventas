package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Mantenimiento;

import java.time.LocalDate;
import java.util.List;

public interface ServiceMantenimiento {
    Mantenimiento crearMantenimiento(Mantenimiento mantenimiento);

    Mantenimiento updateMantenimiento(Integer id, Mantenimiento mantenimiento);

    List<Mantenimiento> findByNombreOrRangeDate(String nombre, LocalDate start, LocalDate end);
}
