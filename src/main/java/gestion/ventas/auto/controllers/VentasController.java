package gestion.ventas.auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.ventas.auto.dto.VentasDTO;
import gestion.ventas.auto.models.Ventas;
import gestion.ventas.auto.service.ServiceVentas;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
	

	@Autowired
    private ServiceVentas serviceVentas;

    @PostMapping
    public ResponseEntity<Ventas> createVenta(@RequestBody VentasDTO ventasDTO) {
        Ventas venta = serviceVentas.createVenta(ventasDTO);
        return ResponseEntity.ok(venta);
    }
}