package gestion.ventas.auto.controllers;

import gestion.ventas.auto.models.Mantenimiento;
import gestion.ventas.auto.service.ServiceMantenimiento;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/mantenimiento")
public class MantenimientoController {

    @Autowired
    private ServiceMantenimiento serviceMantenimiento;

    @PostMapping
    public ResponseEntity<Object> createMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceMantenimiento.crearMantenimiento(mantenimiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> updateMantenimiento(@PathVariable("id") Integer id, @RequestBody Mantenimiento mantenimiento) {
        return Optional.ofNullable(serviceMantenimiento.updateMantenimiento(id, mantenimiento))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Object> findByNombreOrRangeDate(@RequestParam(required = false, defaultValue = "") String nombre,
                                                          @RequestParam
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                          LocalDate start,
                                                          @RequestParam
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                          LocalDate end) {
        return ResponseEntity.ok(serviceMantenimiento.findByNombreOrRangeDate(nombre, start, end));
    }
}
