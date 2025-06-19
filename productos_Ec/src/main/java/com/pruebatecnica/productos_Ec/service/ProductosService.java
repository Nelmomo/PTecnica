package com.pruebatecnica.productos_Ec.service;

import com.pruebatecnica.productos_Ec.model.Productos;
import com.pruebatecnica.productos_Ec.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository repo;

    public Page<Productos> listar(Pageable pageable){
        return repo.findAll(pageable);
    }

    public Productos crear(Productos productos){
        return repo.save(productos);
    }

    public Productos obtener(Long id){
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Productos actualizar(Long id, Productos nuevo){
        Productos enInventario = obtener(id);
        enInventario.setNombre(nuevo.getNombre());
        enInventario.setPrecio(nuevo.getPrecio());
        return repo.save(enInventario);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
    
}
