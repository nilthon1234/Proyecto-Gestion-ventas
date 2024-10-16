package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Documento;
import gestion.ventas.auto.repository.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceDocumentosImpl implements ServiceDocumentos{
    @Autowired
    private IDocumentoRepository repository;
    @Override
    public Documento crearDocumento(Documento documento){
        return repository.save(documento);
    }
    @Override
    public Documento updateDocumento(Integer id, Documento documento){
        return repository.findById(id)
                .map(p -> repository.save(documento))
                .orElse(null);
    }
    @Override
    public List<Documento> findAllDocumentos(){
        return repository.findAll();
    }
}
