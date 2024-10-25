package gestion.ventas.auto.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ventas {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ventas")
    private Integer idVenta;

    @Column(name = "numero_venta", length = 4)
    private String numeroVenta;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Constructor con parámetros
    public Ventas(String numeroVenta, LocalDateTime fechaVenta, Clientes cliente, Usuario usuario) {
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    // Getters y setters...
}
