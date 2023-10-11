package com.example.metaphorce.controller;


import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/create")
    public ResponseEntity<Object>  registrarCategory(@RequestBody  Categoria categoria){
        return this.categoriaServices.newCategoria(categoria);

    }
    @PutMapping("/update")
    public ResponseEntity<Object> actualizar(@RequestBody Categoria categoria){
        return this.categoriaServices.newCategoria(categoria);
    }
}
