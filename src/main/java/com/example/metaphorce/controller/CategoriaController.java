package com.example.metaphorce.controller;


import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.service.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {
    private final CategoriaServices categoriaServices;


    @Autowired
    public CategoriaController(CategoriaServices categoriaServices) {
        this.categoriaServices = categoriaServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getCategoria() {
        return categoriaServices.getCategoria();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getCategoria(@PathVariable Long id) {
        return this.categoriaServices.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarCategoria(@RequestBody Categoria categoria) {
        return this.categoriaServices.newCategoria(categoria);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return this.categoriaServices.updateCategoria(id, categoria);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.categoriaServices.eliminar(id);

    }
}
