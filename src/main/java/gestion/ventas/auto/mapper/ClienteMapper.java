package gestion.ventas.auto.mapper;

import gestion.ventas.auto.dto.ClienteDTO;
import gestion.ventas.auto.models.Clientes;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public ClienteDTO toClienteDTO(Clientes cliente) {
        return ClienteDTO.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .direccion(cliente.getDireccion())
                .celular(cliente.getCelular())
                .correo(cliente.getCorreo())
                .build();
    }

    public Clientes toEntity(ClienteDTO clienteDTO) {
        return Clientes.builder()
                .idCliente(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .direccion(clienteDTO.getDireccion())
                .celular(clienteDTO.getCelular())
                .correo(clienteDTO.getCorreo())
                .build();
    }
}
