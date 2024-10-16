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
    public AutoDTO createAuto(AutoDTO autosDto) {
        Autos mapear = autoMapper.updateAuto(autosDto, new Autos());
        Autos autoGuardado =autosRepository.save(mapear);
        return autoMapper.regisAutoMapper(autoGuardado);
    }

    @Override
    public List<AutoDTO> listAll() {
        List<Autos> auto = autosRepository.findAll();
        return auto.stream()
                .map(autoMapper::lisAllAutoMapper)
                .collect(Collectors.toList());
    }

    @Override
    public AutoDTO updateAutos(String id, AutoDTO autoDto) {
        Autos autos =  autosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auto no encontrado con Id:" + id));

        Autos save = autoMapper.updateAuto(autoDto, autos);
        Autos update = autosRepository.save(save);
        return autoMapper.regisAutoMapper(update);
    }

    @Override
    public void deleteAuto(String id) {
        if (!autosRepository.existsById(id)){
            throw new RuntimeException("Auto no encontrado con: " + id);
        }
         autosRepository.deleteById(id);
    }
}
