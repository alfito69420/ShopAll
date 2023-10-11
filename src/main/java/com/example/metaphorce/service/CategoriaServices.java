package com.example.metaphorce.service;

import com.example.metaphorce.domain.GenericResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoriaServices {

    private final CategoriaRepository categoriaRepository;
    HashMap<String,Object> datos = new HashMap<>();
    GenericResponse response;

    @Autowired
    public CategoriaServices(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getCategoria(){

        return categoriaRepository.findAll();
    }

    public  ResponseEntity<Object> newCategoria(Categoria categoria) {
        this.categoriaRepository.save(categoria);
        datos.put("Data", categoria);
        datos.put("Message","Se pudo crear");
        datos.put("Status",201);
        datos.put("Flag","true");
        if(categoria.getCategoria_id() > 0){
            datos.put("Message","Se pudo actualizar");
        }
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    };
}
