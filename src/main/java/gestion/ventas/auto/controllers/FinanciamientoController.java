package gestion.ventas.auto.controllers;

import gestion.ventas.auto.models.Financiamiento;
import gestion.ventas.auto.service.ServiceFinanciamiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/financiemiento")
public class FinanciamientoController {

    @Autowired
    private ServiceFinanciamiento serviceFinanciamiento;

    @PostMapping
    public ResponseEntity<Object> createFinanciamiento(@RequestBody Financiamiento financiamiento) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceFinanciamiento.createFinanciamiento(financiamiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Financiamiento> updateFinanciamiento(@PathVariable("id") Integer id, @RequestBody Financiamiento financiamiento) {
        return Optional.ofNullable(serviceFinanciamiento.updateFinanciamiento(id, financiamiento))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Object> findByTipoOrRangeDate(@RequestParam(required = false, defaultValue = "") String tipo,
                                                        @RequestParam
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        LocalDate start,
                                                        @RequestParam
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                        LocalDate end) {
        return ResponseEntity.ok(serviceFinanciamiento.findByTipoOrRangeDate(tipo, start, end));
    }
}
