package gestion.ventas.auto.repository;

import gestion.ventas.auto.models.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {
    @Query(value = "select * from mantenimiento where nombre like concat('%', :nombre, '%') and date(fecha_man) between :start and :end",
            nativeQuery = true)
    List<Mantenimiento> findByNombreOrRangeDate(@Param("nombre") String nombre,
                                                @Param("start") LocalDate start,
                                                @Param("end") LocalDate end);
}
