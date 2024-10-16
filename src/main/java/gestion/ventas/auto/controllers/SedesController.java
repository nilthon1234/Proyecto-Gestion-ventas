package gestion.ventas.auto.controllers;
import gestion.ventas.auto.models.Sedes;
import gestion.ventas.auto.service.ServiceSedes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/sedes")
public class SedesController {
    @Autowired
    private ServiceSedes serviceSedes;

    @PostMapping
    public ResponseEntity<Object> crearSede(@RequestBody Sedes sede) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceSedes.crearSede(sede));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sedes> updateSede(@PathVariable("id") Integer id, @RequestBody Sedes sede) {
        return Optional.ofNullable(serviceSedes.updateSede(id, sede))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Object> findAllSedes() {
        return ResponseEntity.ok(serviceSedes.findAllSedes());
    }
}
