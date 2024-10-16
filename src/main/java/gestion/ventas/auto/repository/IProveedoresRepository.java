package gestion.ventas.auto.repository;

import gestion.ventas.auto.models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProveedoresRepository extends JpaRepository<Proveedores, Integer> {
    @Query(value = "from Proveedores p where p.nombre like concat('%', :nombre, '%')")
    List<Proveedores> findByNombre(@Param("nombre") String nombre);
}
