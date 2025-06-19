package com.pruebatecnica.inventario_Ec.service;

import com.pruebatecnica.inventario_Ec.model.Inventario;
import com.pruebatecnica.inventario_Ec.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebatecnica.inventario_Ec.exception.ExceptionRecurso;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repo;

    public Inventario consultar(Long productosId) {
        return repo.findById(productosId)
        .orElseThrow(() -> new ExceptionRecurso("No hay inventario del producto con ID: " + productosId));
    }

    public Inventario crear(Inventario inventario) {
        return repo.save(inventario);
    }

    public Inventario actualizar(Long productosId, int cantidadVendida) {
        Inventario inventario = consultar(productosId);
        inventario.setCantidad(inventario.getCantidad() - cantidadVendida);
        return repo.save(inventario);
    }
}
