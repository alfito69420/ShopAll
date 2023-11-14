package com.example.metaphorce.service;

import com.example.metaphorce.model.*;
import com.example.metaphorce.repository.*;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private VentaRepository ventaRepository;

    @Mock
    private TiendaRepository tiendaRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private TipoProductoRepository tipoProductoRepository;

    @InjectMocks
    ProductoService productoService;

    private Producto producto;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        producto = new Producto();
        producto.setProducto_id(1L);
        //
    }

    @Test
    void getProducto() {
        when(productoRepository.findAll()).thenReturn(Collections.singletonList(new Producto()));

        ResponseEntity <Object> responseEntity = productoService.getProducto();

        assertEquals(200,responseEntity.getStatusCodeValue());
    }

    @Test
    void newProducto() {
        Tienda tienda = new Tienda();
        tienda.setTienda_id(1);
        Categoria categoria = new Categoria();
        categoria.setCategoria_id(1L);
        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setTipo_id(1L);

        producto.setTienda(tienda);
        producto.setCategoria(categoria);
        producto.setTipoProducto(tipoProducto);

        when(tiendaRepository.findById(1)).thenReturn(Optional.of(tienda));
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        when(tipoProductoRepository.findById(1L)).thenReturn(Optional.of(tipoProducto));

        ResponseEntity<Object> responseEntity = productoService.newProducto(producto);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void updateProducto() {
        Long productoId = 1L;
        Producto productoExistente = new Producto();
        productoExistente.setProducto_id(productoId);

        Producto productoActualizado = new Producto();
        productoActualizado.setProducto_id(productoId);
        Categoria categoria = new Categoria();
        TipoProducto tipoProducto = new TipoProducto();
        Tienda tienda = new Tienda();
        productoActualizado.setCategoria(categoria);
        productoActualizado.setTipoProducto(tipoProducto);
        productoActualizado.setTienda(tienda);

        when(productoRepository.findById(productoId)).thenReturn(Optional.of(productoExistente));
        when(categoriaRepository.findById(any())).thenReturn(Optional.of(categoria));
        when(tipoProductoRepository.findById(any())).thenReturn(Optional.of(tipoProducto));
        when(tiendaRepository.findById(any())).thenReturn(Optional.of(tienda));

        ResponseEntity<Object> responseEntity = productoService.updateProducto(productoId, productoActualizado);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }

    @Test
    void eliminar() {
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        ResponseEntity<Object> responseEntity = productoService.eliminar(1);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOne() {
        producto.setProducto_id(1L);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        ResponseEntity<Object> responseEntity = productoService.getOne(1);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}