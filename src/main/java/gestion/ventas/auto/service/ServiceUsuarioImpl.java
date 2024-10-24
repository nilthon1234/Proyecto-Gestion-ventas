package gestion.ventas.auto.service;

import gestion.ventas.auto.dto.AccessDTO;
import gestion.ventas.auto.dto.AuthDTO;
import gestion.ventas.auto.security.AuthProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gestion.ventas.auto.dto.UsuarioDTO;
import gestion.ventas.auto.models.Usuario;
import gestion.ventas.auto.repository.IUsuarioRepository;
import gestion.ventas.auto.repository.IDocumentoRepository; // Asegúrate de tener este repositorio
import gestion.ventas.auto.repository.ISedesRepository; // Asegúrate de tener este repositorio
import gestion.ventas.auto.repository.IRolRepository; // Asegúrate de tener este repositorio

import java.util.Optional;

@Slf4j
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

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AuthProvider authProvider;

    @Override
    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setCelular(usuarioDTO.getCelular());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(encoder.encode(usuarioDTO.getPassword()));
        
        usuario.setDocumento(documentoRepository.findById(usuarioDTO.getDocumento()).orElse(null));
        usuario.setSede(sedeRepository.findById(usuarioDTO.getSede()).orElse(null));
        usuario.setRol(rolRepository.findById(usuarioDTO.getRol()).orElse(null));

        return repository.save(usuario);
    }

    @Override
    public Optional<AccessDTO> loginUsuario(AuthDTO authDTO) {
        return Optional.ofNullable(repository.findByUsername(authDTO.getUsername())
                .map(u -> {
                    boolean isValid = encoder.matches(authDTO.getPassword(), u.getPassword());
                    if (isValid) {
                        final String token = authProvider.createToken(u);
                        u.setPassword(null);
                        log.info(String.format("Token: %s", token));
                        return AccessDTO.builder().token(token).build();
                    }
                    return null;
                }).orElseGet(() -> null));
    }
}

