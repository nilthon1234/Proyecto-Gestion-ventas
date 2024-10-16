package gestion.ventas.auto.controllers;
import gestion.ventas.auto.models.Documento;
import gestion.ventas.auto.service.ServiceDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {
    @Autowired
    private ServiceDocumentos serviceDocumentos;
    @PostMapping
    public ResponseEntity<Object> crearDocumento(@RequestBody Documento documento){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceDocumentos.crearDocumento(documento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Documento> updateDocumento(@PathVariable("id") Integer id, @RequestBody Documento documento){
        return Optional.ofNullable(serviceDocumentos.updateDocumento(id, documento))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<Object> findAllDocumentos(){
        return ResponseEntity.ok(serviceDocumentos.findAllDocumentos());
    }
    
}
