package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.Autos;

import java.util.List;

public interface ServiceAutos {
    AutoDTO createAuto (AutoDTO autosDto);
    List<AutoDTO> listAll();
    AutoDTO updateAutos(Integer id, AutoDTO autoDto);
    void deleteAuto(Integer id);
}
