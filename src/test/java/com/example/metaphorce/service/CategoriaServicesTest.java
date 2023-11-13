package com.example.metaphorce.service;

import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

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
        categoria.setCategoria_id(new Long(11));

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
    }

    @Test
    void eliminar() {
    }

    @Test
    void getOne() {
    }
}