package gestion.ventas.auto.service;
import gestion.ventas.auto.models.Documento;
import java.util.List;

public interface ServiceDocumentos {
    Documento crearDocumento(Documento documento);
    Documento updateDocumento(Integer id, Documento documento);
    List<Documento> findAllDocumentos();
}
