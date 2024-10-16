package gestion.ventas.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.ventas.auto.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {

}
