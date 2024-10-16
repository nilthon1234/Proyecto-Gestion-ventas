package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Financiamiento;
import gestion.ventas.auto.repository.IFinanciamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceFinanciamientoImpl implements ServiceFinanciamiento {

    @Autowired
    private IFinanciamientoRepository repository;

    @Override
    public Financiamiento createFinanciamiento(Financiamiento financiamiento) {
        return repository.save(financiamiento);
    }

    @Override
    public Financiamiento updateFinanciamiento(Integer id, Financiamiento financiamiento) {
        return repository.findById(id)
                .map(f -> repository.save(financiamiento))
                .orElse(null);
    }

    @Override
    public List<Financiamiento> findByTipoOrRangeDate(String tipo, LocalDate start, LocalDate end) {
        return repository.findByTipoOrRangeDate(tipo, start, end);
    }
}
