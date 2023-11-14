package com.example.metaphorce.service;

import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CategoriaServicesTest {
    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServices categoriaServices;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        categoria = new Categoria();
        categoria.setNombre("Prueba Unitaria");
        categoria.setCategoria_id(11L);

    }

    @Test
    void getCategoria() {
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(categoria));
        assertNotNull(categoriaServices.getCategoria());
    }

    @Test
    void newCategoria() {
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
        assertNotNull(categoriaServices.newCategoria(new Categoria()));
    }

    @Test
    void updateCategoria() {
        Categoria existCategoria = new Categoria();
        existCategoria.setCategoria_id(1L);

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(existCategoria));

        Categoria updCategoria = new Categoria();
        updCategoria.setNombre("Nueva cat");

        ResponseEntity<Object> responseEntity = categoriaServices.updateCategoria(1L,updCategoria);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void eliminar() {
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(new Categoria()));
        ResponseEntity<Object> responseEntity = categoriaServices.eliminar(1L);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void getOne() {
        categoria.setCategoria_id(1L);
        Optional<Categoria> optionalCategoria = Optional.of(categoria);


    }
}