package gestion.ventas.auto.service;

import gestion.ventas.auto.models.Proveedores;

import java.util.List;

public interface ServiceProveedores {
    Proveedores createProveedor(Proveedores proveedor);

    Proveedores updateProveedor(Integer id, Proveedores proveedor);

    List<Proveedores> findAllProveedores();

    List<Proveedores> findAllProveedoresByNombre(String nombre);
}
