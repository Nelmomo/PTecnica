package com.pruebatecnica.inventario_Ec.controller;

import com.pruebatecnica.dto.InventarioRequest;
import com.pruebatecnica.inventario_Ec.model.Inventario;
import com.pruebatecnica.inventario_Ec.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService servicio;

    @GetMapping("/{productosId}")
    public Inventario consultar(@PathVariable("productosId") Long productosId) {
        return servicio.consultar(productosId);
    }

    @PatchMapping("/{productosId}")
    public Inventario actualizar(
            @PathVariable("productosId") Long productosId,
            @RequestBody InventarioRequest request) {
        int cantidadVendida = request.getData().getAttributes().getCantidad();
        return servicio.actualizar(productosId, cantidadVendida);
    }

    @PostMapping
    public Inventario crear(@RequestBody InventarioRequest request) {
        Long productosId = request.getData().getAttributes().getProductos_id();
        Integer cantidad = request.getData().getAttributes().getCantidad();

        Inventario inventario = new Inventario();
        inventario.setProductosId(productosId);
        inventario.setCantidad(cantidad);

        return servicio.crear(inventario);
    }
}

