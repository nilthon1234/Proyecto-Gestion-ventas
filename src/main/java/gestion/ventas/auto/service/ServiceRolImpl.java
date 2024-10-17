package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Rol;
import gestion.ventas.auto.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServiceRolImpl implements ServiceRol{
    @Autowired
    private IRolRepository repository;
    @Override
    public Rol crearRol(Rol rol){
        return repository.save(rol);
    }
    @Override
    public Rol updateRol(Integer id, Rol rol){
        return repository.findById(id)
                .map(p -> repository.save(rol))
                .orElse(null);
    }
    @Override
    public List<Rol> findAllRoles(){
        return repository.findAll();
    }
}
