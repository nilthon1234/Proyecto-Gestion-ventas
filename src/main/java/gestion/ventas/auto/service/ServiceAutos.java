package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.Autos;

import java.util.List;

public interface ServiceAutos {
    Autos createAuto (AutoDTO autosDto);
    List<AutoDTO> listAll();
}
