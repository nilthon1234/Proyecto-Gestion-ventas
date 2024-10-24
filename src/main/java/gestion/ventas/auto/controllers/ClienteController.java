package gestion.ventas.auto.controllers;

import gestion.ventas.auto.dto.ClienteDTO;
import gestion.ventas.auto.models.Clientes;
import gestion.ventas.auto.service.ServiceClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ServiceClientes serviceClientes;

    @PostMapping
    public ResponseEntity<Object> createCliente(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceClientes.createCliente(clienteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateCliente(@PathVariable("id") Integer id, @RequestBody ClienteDTO clienteDTO) {
        return Optional.ofNullable(serviceClientes.updateCliente(id, clienteDTO))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Object> findAllClientesByNombreOrApellido(@RequestParam(required = false, defaultValue = "") String nombre) {
        return ResponseEntity.ok(serviceClientes.findAllClientesByNombreOrApellido(nombre));
    }
}
