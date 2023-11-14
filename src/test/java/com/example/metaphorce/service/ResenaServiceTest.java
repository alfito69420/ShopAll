package com.example.metaphorce.service;

import com.example.metaphorce.domain.ResenaResponse;
import com.example.metaphorce.model.*;
import com.example.metaphorce.repository.ProductoRepository;
import com.example.metaphorce.repository.ResenaRepository;
import com.example.metaphorce.repository.UserRepository;
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

class ResenaServiceTest {
    @Mock
    private  ResenaRepository resenaRepository;
    @Mock
    private  UserRepository userRepository;
    @Mock
    private  ProductoRepository productoRepository;

    @InjectMocks
    ResenaService resenaService;

    private Resena resena;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        resena = new Resena();
        resena.setResena_id(1L);
    }

    @Test
    void getResena() {
        when(resenaRepository.findAll()).thenReturn(Collections.singletonList(new Resena()));

        // Ejecutar el método a probar
        ResponseEntity<Object> responseEntity = resenaService.getResena();

        // Verificar el resultado
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void newResena() {
        UserEntity user = new UserEntity();
        user.setUsuario_id(1L);
        Producto producto = new Producto();
        producto.setProducto_id(1L);

        resena.setUser(user);
        resena.setProducto(producto);
        resena.setCalificacion(4);
        resena.setResena("Prueba");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        ResponseEntity<Object> responseEntity=resenaService.newResena(resena);

        assertEquals(200,responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void updateResena() {
        Resena existResena = new Resena();
        existResena.setResena_id(1L);
        when(resenaRepository.findById(1L)).thenReturn(Optional.of(existResena));

        Resena updaResena = new Resena();
        Producto producto = new Producto();
        producto.setProducto_id(1L);
        UserEntity user = new UserEntity();
        user.setUsuario_id(1L);
        updaResena.setUser(user);
        updaResena.setProducto(producto);
        updaResena.setCalificacion(5);

        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<Object> responseEntity=resenaService.updateResena(1L,updaResena);

        assertEquals(200,responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void eliminarResena() {
        when(resenaRepository.findById(1L)).thenReturn(Optional.of(new Resena()));

        ResponseEntity<Object> responseEntity=resenaService.eliminarResena(1L);

        assertEquals(200,responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOne() {
        resena.setResena_id(1L);
        when(resenaRepository.findById(1L)).thenReturn(Optional.of(resena));
        ResponseEntity<Object> responseEntity = resenaService.getOne(1L);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}