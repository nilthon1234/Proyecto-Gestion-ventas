package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.ClienteDTO;
import gestion.ventas.auto.models.Clientes;

import java.util.List;

public interface ServiceClientes {
    Clientes createCliente(ClienteDTO clienteDTO);

    Clientes updateCliente(Integer id, ClienteDTO clienteDTO);

    List<ClienteDTO> findAllClientes();

    List<ClienteDTO> findAllClientesByNombreOrApellido(String nombre);
}
