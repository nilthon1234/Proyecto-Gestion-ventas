package gestion.ventas.auto.controllers;
import gestion.ventas.auto.models.Rol;
import gestion.ventas.auto.service.ServiceRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    @Autowired
    private ServiceRol serviceRol;
    @PostMapping
    public ResponseEntity<Object> crearRol(@RequestBody Rol rol){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceRol.crearRol(rol));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable("id") Integer id, @RequestBody Rol rol){
        return Optional.ofNullable(serviceRol.updateRol(id, rol))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<Object> findAllRoles(){
        return ResponseEntity.ok(serviceRol.findAllRoles());
    }
}
