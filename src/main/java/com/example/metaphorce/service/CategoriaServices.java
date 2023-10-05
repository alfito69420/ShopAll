package com.example.metaphorce.service;

import com.example.metaphorce.domain.GenericResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServices {

    private final CategoriaRepository categoriaRepository;
    GenericResponse response;

    @Autowired
    public CategoriaServices(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getCategoria(){

        return categoriaRepository.findAll();
    }

    public  GenericResponse newCategoria(Categoria categoria) {
        this.categoriaRepository.save(categoria);
        return response = new GenericResponse("Se ha gaurdado el repsoitorio",200);

    };
}
