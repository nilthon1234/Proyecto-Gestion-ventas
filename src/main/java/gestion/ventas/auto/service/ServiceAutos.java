package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Autos;

import java.util.List;

public interface ServiceAutos {
    Autos createAuto (Autos autos);
    List<Autos> listAll();
}
