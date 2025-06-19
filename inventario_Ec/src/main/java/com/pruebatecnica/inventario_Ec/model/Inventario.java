package com.pruebatecnica.inventario_Ec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventarios")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productos_id", nullable = false)
    private Long productosId;

    private Integer cantidad;
}
