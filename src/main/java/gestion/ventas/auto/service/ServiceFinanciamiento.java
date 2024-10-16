package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Financiamiento;

import java.time.LocalDate;
import java.util.List;

public interface ServiceFinanciamiento {
    Financiamiento createFinanciamiento(Financiamiento financiamiento);

    Financiamiento updateFinanciamiento(Integer id, Financiamiento financiamiento);

    List<Financiamiento> findByTipoOrRangeDate(String tipo, LocalDate start, LocalDate end);
}
