package gestion.ventas.auto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.ventas.auto.service.VentasServiceImpl;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
	
	private final VentasServiceImpl ventasService;

    public VentasController(VentasServiceImpl ventasService) {
        this.ventasService = ventasService;
    }

    
}