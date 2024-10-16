package gestion.ventas.auto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestion.ventas.auto.models.Usuario;
import gestion.ventas.auto.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(int id, Usuario usuario) {
        usuario.setIdUsuario(id); // Asignar el ID para la actualización
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}