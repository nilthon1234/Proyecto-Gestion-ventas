package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Proveedores;
import gestion.ventas.auto.repository.IProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProveedoresImpl implements ServiceProveedores {

    @Autowired
    private IProveedoresRepository repository;

    @Override
    public Proveedores createProveedor(Proveedores proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public Proveedores updateProveedor(Integer id, Proveedores proveedor) {
        return repository.findById(id)
                .map(p -> repository.save(proveedor))
                .orElse(null);
    }

    @Override
    public List<Proveedores> findAllProveedores() {
        return repository.findAll();
    }

    @Override
    public List<Proveedores> findAllProveedoresByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}
