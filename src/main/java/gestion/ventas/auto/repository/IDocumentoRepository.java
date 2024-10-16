package gestion.ventas.auto.repository;
import gestion.ventas.auto.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoRepository extends JpaRepository<Documento,Integer>{
    
}
