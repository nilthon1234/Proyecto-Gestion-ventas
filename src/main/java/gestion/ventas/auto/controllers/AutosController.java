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
    public ResponseEntity<Map<String, String>> registrarAuto(@RequestBody AutoDTO autoDTO){
        Map<String, String> response = new HashMap<>();
        try {
            serviceAutos.createAuto(autoDTO);
            response.put("message", "Auto Registrado Correctamente");
            return new  ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            response.put("message",  "ERROR AL AGREGAR");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
