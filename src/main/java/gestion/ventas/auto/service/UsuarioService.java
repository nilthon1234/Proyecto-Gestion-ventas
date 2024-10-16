package gestion.ventas.auto.service;

import java.util.List;

import gestion.ventas.auto.models.Usuario;

public interface UsuarioService {
	List<Usuario> listAll();
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuario(int id, Usuario usuario);
    void deleteUsuario(int id);

}
