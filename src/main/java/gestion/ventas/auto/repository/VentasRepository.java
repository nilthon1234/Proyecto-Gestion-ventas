package gestion.ventas.auto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.ventas.auto.models.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Integer>{

}
