package gestion.ventas.auto.controllers;

import gestion.ventas.auto.models.Proveedores;
import gestion.ventas.auto.service.ServiceProveedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ServiceProveedores serviceProveedores;

    @PostMapping
    public ResponseEntity<Object> createProveedor(@RequestBody Proveedores proveedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProveedores.createProveedor(proveedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> updateProveedor(@PathVariable("id") Integer id, @RequestBody Proveedores proveedor) {
        return Optional.ofNullable(serviceProveedores.updateProveedor(id, proveedor))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Object> findAllProveedoresByNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(serviceProveedores.findAllProveedoresByNombre(nombre));
    }
}
