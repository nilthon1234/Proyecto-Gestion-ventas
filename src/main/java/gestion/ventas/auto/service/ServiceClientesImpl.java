package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.ClienteDTO;
import gestion.ventas.auto.mapper.ClienteMapper;
import gestion.ventas.auto.models.Clientes;
import gestion.ventas.auto.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClientesImpl implements ServiceClientes {

    @Autowired
    private IClientesRepository repository;
    @Autowired
    private ClienteMapper mapper;

    @Override
    public Clientes createCliente(ClienteDTO clienteDTO) {
        return repository.save(mapper.toEntity(clienteDTO));
    }

    @Override
    public Clientes updateCliente(Integer id, ClienteDTO clienteDTO) {
        clienteDTO.setIdCliente(id);
        return repository.findById(id)
                .map(c -> repository.save(mapper.toEntity(clienteDTO)))
                .orElse(null);
    }

    @Override
    public List<ClienteDTO> findAllClientes() {
        return repository.findAll().stream()
                .map(mapper::toClienteDTO)
                .toList();
    }

    @Override
    public List<ClienteDTO> findAllClientesByNombreOrApellido(String nombre) {
        return repository.findAllClientesByNombreOrApellido(nombre)
                .stream().map(mapper::toClienteDTO)
                .toList();
    }
}
