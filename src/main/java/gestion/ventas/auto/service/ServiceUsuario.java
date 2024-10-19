package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;

public interface ServiceUsuario {
    Usuario createUsuario(UsuarioDTO usuarioDTO);
    // Puedes agregar otros métodos como listAll, findById, updateUsuario, etc.
}
