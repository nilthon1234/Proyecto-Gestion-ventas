package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Sedes;

import java.util.List;

public interface ServiceSedes {
    Sedes crearSede(Sedes sede);
    Sedes updateSede(Integer id,Sedes sede);
    List<Sedes> findAllSedes();
}
