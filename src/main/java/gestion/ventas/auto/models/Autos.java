package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Autos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autos")
    private String idAuto;
    private String nombre;
    private String marca;
    private String modelo;
    private String color;
    @Column(name = "año")
    private String anio;
    private String tipo_motor;
    private String capacidad;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "sede")
    private Sedes sede;
    @ManyToOne
    @JoinColumn(name = "proveedor")
    private Proveedores proveedor;
    @ManyToOne
    @JoinColumn(name = "mantenimiento")
    private Mantenimiento mantenimiento;
    @ManyToOne
    @JoinColumn(name = "financiamiento")
    private Financiamiento financiamiento;
    @ManyToOne
    @JoinColumn(name = "venta")
    private Ventas venta;


}
