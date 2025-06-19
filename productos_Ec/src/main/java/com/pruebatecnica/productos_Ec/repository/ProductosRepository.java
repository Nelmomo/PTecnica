package com.pruebatecnica.productos_Ec.repository;

import com.pruebatecnica.productos_Ec.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    
}
