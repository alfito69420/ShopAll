package com.example.metaphorce.controller;

import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {
    private final CategoriaServices categoriaServices;

    @Autowired
    public CategoriaController(CategoriaServices categoriaServices){
        this.categoriaServices = categoriaServices;
    }

    @GetMapping("/all")
    public List<Categoria> getCategoria(){
        return categoriaServices.getCategoria();
    }
}
