package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Rol;
import java.util.List;

public interface ServiceRol {
    Rol crearRol(Rol rol);
    Rol updateRol(Integer id, Rol rol);
    List<Rol> findAllRoles();
    
}
