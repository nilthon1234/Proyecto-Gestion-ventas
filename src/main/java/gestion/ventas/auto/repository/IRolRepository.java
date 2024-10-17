package gestion.ventas.auto.repository;
import gestion.ventas.auto.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository <Rol,Integer>{
    
}
