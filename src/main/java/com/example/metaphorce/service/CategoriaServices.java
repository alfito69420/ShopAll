package com.example.metaphorce.service;

import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServices {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServices(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getCategoria(){
        return categoriaRepository.findAll();
    }
}
