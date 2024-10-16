package gestion.ventas.auto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Financiamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_financiamiento")
    private Integer idFinaciamiento;
    @Column(name = "tipofinanciamiento")
    private String tipoFinanciamiento;
    private Double monto;
    private Double interes;
    private String plazo;
    @Column(name = "fecha_finan")
    private LocalDateTime fechaFinan;
}
