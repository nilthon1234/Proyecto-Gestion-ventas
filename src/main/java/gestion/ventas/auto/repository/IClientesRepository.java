package gestion.ventas.auto.repository;

import gestion.ventas.auto.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes, Integer> {
    @Query(value = "from Clientes c where (concat(c.nombre, ' ', c.apellido)) like concat('%', :nombre, '%')")
    List<Clientes> findAllClientesByNombreOrApellido(@Param("nombre") String nombre);
}
