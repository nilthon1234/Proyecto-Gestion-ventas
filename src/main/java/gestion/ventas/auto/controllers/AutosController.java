package gestion.ventas.auto.controllers;

import gestion.ventas.auto.models.Autos;
import gestion.ventas.auto.service.ServiceAutos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class AutosController {

    private final ServiceAutos serviceAutos;
    public AutosController (ServiceAutos serviceAutos){
        this.serviceAutos = serviceAutos;
    }
    @GetMapping("/listar-autos")
    public List<Autos> listarTodo (){
        return serviceAutos.listAll();
    }
}
