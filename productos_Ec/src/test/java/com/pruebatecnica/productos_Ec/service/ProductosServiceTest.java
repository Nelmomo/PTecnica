package com.pruebatecnica.productos_Ec.service;

import com.pruebatecnica.productos_Ec.model.Productos;
import com.pruebatecnica.productos_Ec.repository.ProductosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductosServiceTest {

    @Mock
    private ProductosRepository productosRepository;

    @InjectMocks
    private ProductosService productosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearProducto_deberiaGuardarYRetornarProducto() {
        Productos producto = Productos.builder()
                .nombre("Camisa")
                .categoria("Ropa")
                .precio(15000)
                .build();

        when(productosRepository.save(any(Productos.class))).thenReturn(producto);

        Productos resultado = productosService.crear(producto);

        assertNotNull(resultado);
        assertEquals("Camisa", resultado.getNombre());
        verify(productosRepository, times(1)).save(producto);
    }

    @Test
    void consultarProducto_existente_retornaProducto() {
        Productos producto = Productos.builder()
                .nombre("Pantalón")
                .categoria("Ropa")
                .precio(30000)
                .build();

        producto.setId(1L);

        when(productosRepository.findById(1L)).thenReturn(Optional.of(producto));

        Productos resultado = productosService.obtener(1L);

        assertNotNull(resultado);
        assertEquals("Pantalón", resultado.getNombre());
    }

    @Test
    void consultarProducto_noExistente_lanzaExcepcion() {
        when(productosRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productosService.obtener(99L);
        });

        assertEquals("Producto no encontrado", exception.getMessage());
    }
}

