package gestion.ventas.auto.repository;

import gestion.ventas.auto.models.Financiamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IFinanciamientoRepository extends JpaRepository<Financiamiento, Integer> {

    @Query(value = "select * from financiamiento where tipofinanciamiento like concat('%', :tipo, '%') and date(fecha_finan) between :start and :end",
            nativeQuery = true)
    List<Financiamiento> findByTipoOrRangeDate(@Param("tipo") String tipo, @Param("start") LocalDate start, @Param("end") LocalDate end);
}
