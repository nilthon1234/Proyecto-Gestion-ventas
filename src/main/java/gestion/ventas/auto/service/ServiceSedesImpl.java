package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Sedes;
import gestion.ventas.auto.repository.ISedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceSedesImpl implements ServiceSedes{
    @Autowired
    private ISedesRepository repository;
    @Override
    public Sedes crearSede(Sedes sede){
        return repository.save(sede);
    }

    @Override
    public Sedes updateSede(Integer id, Sedes sede){
        return repository.findById(id)
                .map(p -> repository.save(sede))
                .orElse(null);
    }

    @Override
    public List<Sedes> findAllSedes(){
        return repository.findAll();
    }
    
}
