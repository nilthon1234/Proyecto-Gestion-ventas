package gestion.ventas.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.ventas.auto.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
