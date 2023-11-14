package com.example.metaphorce.service;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.model.Venta;
import com.example.metaphorce.repository.TipoPagoRepository;
import com.example.metaphorce.repository.UserRepository;
import com.example.metaphorce.repository.VentaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class VentaServicesTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private TipoPagoRepository tipoPagoRepository;

    @Mock
    private VentaRepository ventaRepository;

    @InjectMocks
    VentaServices ventaServices;

    private Venta venta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        venta = new Venta();
    }

    @Test
    void getVenta() {
        when(ventaRepository.findAll()).thenReturn(Collections.singletonList(new Venta()));

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = ventaServices.getVenta();

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    void getOne() {
        // Simular el comportamiento del repositorio al devolver un Optional con un valor
        Venta venta = new Venta();
        venta.setVenta_id(1L);
        Optional<Venta> opVenta = Optional.of(venta);

        // Configurar el comportamiento esperado del repositorio
        when(ventaRepository.findById(1L)).thenReturn(opVenta);

        // Llamar a la función del servicio
        ResponseEntity<Object> responseEntity = ventaServices.getOne(1L);

        // Verificar el resultado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void newVenta() {
        UserEntity user = new UserEntity();
        user.setUsuario_id(1L);
        TipoPago tipoPago = new TipoPago();
        tipoPago.setTipo_pago_id(1L);

        Venta venta = new Venta();
        venta.setUser(user);
        venta.setTipoPago(tipoPago);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(tipoPagoRepository.findById(1L)).thenReturn(Optional.of(tipoPago));

        ResponseEntity<Object> responseEntity = ventaServices.newVenta(venta);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void updateVenta() {
        Venta existVenta = new Venta();
        existVenta.setVenta_id(1L);

        when(ventaRepository.findById(1L)).thenReturn(Optional.of(existVenta));

        Venta updVenta = new Venta();
        UserEntity upUser = new UserEntity();
        upUser.setUsuario_id(2L);

        updVenta.setUser(upUser);

        ResponseEntity<Object> responseEntity = ventaServices.updateVenta(1L, updVenta);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void eliminar() {
        when(ventaRepository.findById(1L)).thenReturn(Optional.of(venta));

        ResponseEntity<Object> responseEntity = ventaServices.eliminar(1L);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}