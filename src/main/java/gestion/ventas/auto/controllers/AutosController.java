package gestion.ventas.auto.controllers;

import gestion.ventas.auto.dto.AutoDTO;
import gestion.ventas.auto.models.Autos;
import gestion.ventas.auto.service.ServiceAutos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class AutosController {

    private final ServiceAutos serviceAutos;
    public AutosController (ServiceAutos serviceAutos){
        this.serviceAutos = serviceAutos;
    }
    @GetMapping("/listar-autos")
    public List<AutoDTO> listarTodo (){
        return serviceAutos.listAll();
    }
    @PostMapping("/add-auto")
    public ResponseEntity<?> registrarAuto(@RequestBody AutoDTO autoDTO){
        return ResponseEntity.ok(serviceAutos.createAuto(autoDTO));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAutos(@PathVariable String id, @RequestBody AutoDTO autoDTO){
        return ResponseEntity.ok(serviceAutos.updateAutos(id, autoDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        try {
            serviceAutos.deleteAuto(id);
            return ResponseEntity.ok("Auto eliminado: " + id);

        }catch (RuntimeException e){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
