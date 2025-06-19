package com.pruebatecnica.productos_Ec.controller;

import com.pruebatecnica.dto.ProductosRequest;
import com.pruebatecnica.productos_Ec.model.Productos;
import com.pruebatecnica.productos_Ec.repository.ProductosRepository;
import com.pruebatecnica.productos_Ec.service.ProductosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService servicio;

    @Autowired
    private ProductosRepository productosRepository;
    @GetMapping
    public Page<Productos> listar(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return servicio.listar(pageable);
    }

    @PostMapping
    public ResponseEntity<Productos> crearProductos(@RequestBody ProductosRequest request) {
        String nombre = request.getData().getAttributes().getNombre();
        int precio = (int) request.getData().getAttributes().getPrecio();

        Productos producto = new Productos();
        producto.setNombre(nombre);
        producto.setPrecio(precio);

        Productos guardado = productosRepository.save(producto);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public Productos obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @PatchMapping("/{id}")
    public Productos actualizar(@PathVariable Long id, @RequestBody ProductosRequest request) {
        String nombre = request.getData().getAttributes().getNombre();
        int precio = request.getData().getAttributes().getPrecio();

        Productos productoActualizado = new Productos();
        productoActualizado.setNombre(nombre);
        productoActualizado.setPrecio(precio);

        return servicio.actualizar(id, productoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
