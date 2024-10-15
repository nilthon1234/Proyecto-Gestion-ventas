package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.mapper.AutoMapper;
import gestion.ventas.auto.models.Autos;
import gestion.ventas.auto.repository.IAutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAutoImpl implements ServiceAutos {

    private final IAutosRepository autosRepository;
    private final AutoMapper autoMapper;

    public ServiceAutoImpl (
            IAutosRepository autosRepository,
            AutoMapper autoMapper) {
        this.autosRepository = autosRepository;
        this.autoMapper = autoMapper;
    }
    @Override
    public Autos createAuto(AutoDTO autosDto) {
        Autos add = autoMapper.regisAutoMapper(autosDto);
        return autosRepository.save(add);
    }

    @Override
    public List<AutoDTO> listAll() {
        List<Autos> auto = autosRepository.findAll();
        return auto.stream()
                .map(autoMapper::lisAllAutoMapper)
                .collect(Collectors.toList());
    }
}
