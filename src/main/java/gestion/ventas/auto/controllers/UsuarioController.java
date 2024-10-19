package gestion.ventas.auto.controllers;

import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;
import gestion.ventas.auto.service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioCreado = serviceUsuario.createUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }
}
