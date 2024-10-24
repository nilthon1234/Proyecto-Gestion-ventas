package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.AccessDTO;
import gestion.ventas.auto.dto.AuthDTO;
import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;

import java.util.Optional;

public interface ServiceUsuario {
    Usuario createUsuario(UsuarioDTO usuarioDTO);

    Optional<AccessDTO> loginUsuario(AuthDTO authDTO);
    // Puedes agregar otros métodos como listAll, findById, updateUsuario, etc.
}
