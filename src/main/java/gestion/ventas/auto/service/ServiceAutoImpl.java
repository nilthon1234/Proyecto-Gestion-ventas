package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Autos;
import gestion.ventas.auto.repository.IAutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAutoImpl implements ServiceAutos {

    private final IAutosRepository autosRepository;

    public ServiceAutoImpl (IAutosRepository autosRepository) {
        this.autosRepository = autosRepository;
    }
    @Override
    public Autos createAuto(Autos autos) {
        return autosRepository.save(autos);
    }

    @Override
    public List<Autos> listAll() {
        return autosRepository.findAll();
    }
}
