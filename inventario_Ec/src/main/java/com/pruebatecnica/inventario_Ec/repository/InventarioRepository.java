package com.pruebatecnica.inventario_Ec.repository;

import com.pruebatecnica.inventario_Ec.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
