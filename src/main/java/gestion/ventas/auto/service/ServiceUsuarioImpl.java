package gestion.ventas.auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;
import gestion.ventas.auto.repository.IUsuarioRepository;
import gestion.ventas.auto.repository.IDocumentoRepository; // Asegúrate de tener este repositorio
import gestion.ventas.auto.repository.ISedesRepository; // Asegúrate de tener este repositorio
import gestion.ventas.auto.repository.IRolRepository; // Asegúrate de tener este repositorio

@Service
public class ServiceUsuarioImpl implements ServiceUsuario {

    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private IDocumentoRepository documentoRepository;

    @Autowired
    private ISedesRepository sedeRepository; 

    @Autowired
    private IRolRepository rolRepository; 

    @Override
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setCelular(usuarioDTO.getCelular());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setContraseña(usuarioDTO.getContraseña());
        
        usuario.setDocumento(documentoRepository.findById(usuarioDTO.getDocumento()).orElse(null));
        usuario.setSede(sedeRepository.findById(usuarioDTO.getSede()).orElse(null));
        usuario.setRol(rolRepository.findById(usuarioDTO.getRol()).orElse(null));

        return repository.save(usuario);
    }
}

