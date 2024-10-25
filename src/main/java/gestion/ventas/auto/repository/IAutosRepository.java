package gestion.ventas.auto.repository;

import gestion.ventas.auto.models.Autos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutosRepository extends JpaRepository<Autos, Integer > {
}
