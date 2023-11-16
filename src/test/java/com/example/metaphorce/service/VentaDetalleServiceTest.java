package com.example.metaphorce.service;

import com.example.metaphorce.model.Producto;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.repository.ProductoRepository;
import com.example.metaphorce.repository.VentaDetalleRepository;
import com.example.metaphorce.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VentaDetalleServiceTest {

    @Mock
    private VentaRepository ventaRepository;
    @Mock
    private ProductoRepository productoRepository;
    @Mock
    private VentaDetalleRepository ventaDetalleRepository;
    @InjectMocks
    VentaDetalleService ventaDetalleService;
    private VentaDetalle ventaDetalle;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ventaDetalle = new VentaDetalle();
        ventaDetalle.setId_venta_detalle(1);
    }

    @Test
    void getVentaDetalle() {
        when(ventaDetalleRepository.findAll()).thenReturn(Collections.singletonList(new VentaDetalle()));
        ResponseEntity<Object> responseEntity = ventaDetalleService.getVentaDetalle();
        assertEquals(200,responseEntity.getStatusCodeValue());
    }

    @Test
    void insertVentaDetalle() {
        Venta venta = new Venta();
        venta.setVenta_id(1L);
        Producto producto = new Producto();
        producto.setProducto_id(1L);

        ventaDetalle.setVenta(venta);
        ventaDetalle.setProducto(producto);

        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(ventaRepository.findById(1L)).thenReturn(Optional.of(venta));

        ResponseEntity<Object> responseEntity = ventaDetalleService.insertVentaDetalle(ventaDetalle);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void updateVentaDetalle() {
        VentaDetalle existVentaDetalle = new VentaDetalle();
        existVentaDetalle.setId_venta_detalle(1L);

        VentaDetalle updateVentaDetalle = new VentaDetalle();
        updateVentaDetalle.setId_venta_detalle(1L);

        Venta venta = new Venta();
        venta.setVenta_id(1L);
        Producto producto = new Producto();
        producto.setProducto_id(1L);

        updateVentaDetalle.setProducto(producto);
        updateVentaDetalle.setVenta(venta);
        updateVentaDetalle.setCantidad(5);

        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(ventaRepository.findById(1L)).thenReturn(Optional.of(venta));

        ResponseEntity<Object> responseEntity = ventaDetalleService.updateVentaDetalle(1L,updateVentaDetalle);
    }

    @Test
    void deleteVentaDetalle() {
        when(ventaDetalleRepository.findById(1L)).thenReturn(Optional.of(ventaDetalle));
        ResponseEntity<Object> responseEntity = ventaDetalleService.deleteVentaDetalle(1L);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOneVentaDetalle() {
        ventaDetalle.setId_venta_detalle(1L);
        when(ventaDetalleRepository.findById(1L)).thenReturn(Optional.of(ventaDetalle));
        ResponseEntity<Object> responseEntity = ventaDetalleService.getOneVentaDetalle(1L);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}