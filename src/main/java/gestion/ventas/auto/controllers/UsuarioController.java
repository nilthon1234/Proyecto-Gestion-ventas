package gestion.ventas.auto.controllers;

import gestion.ventas.auto.dto.AuthDTO;
import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;
import gestion.ventas.auto.service.ServiceUsuario;
import gestion.ventas.auto.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioCreado = serviceUsuario.createUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthDTO user) {
        return serviceUsuario.loginUsuario(user)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(MessageUtil.builder()
                                .message("Acceso incorrecto")
                                .timestamp(new Date())
                                .status(HttpStatus.UNAUTHORIZED.value())
                                .build()));

    }
}
