package com.example.metaphorce.service;

import com.example.metaphorce.domain.CategoriaResponse;
import com.example.metaphorce.domain.GenericResponse;
import com.example.metaphorce.domain.CategoriaResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoriaServices {

    private final CategoriaRepository categoriaRepository;
   
    CategoriaResponse response;

    @Autowired
    public CategoriaServices(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

      public ResponseEntity<Object> getCategoria(){
        List<Categoria> categorias = categoriaRepository.findAll();
        if (!categorias.isEmpty()) {
            response = new CategoriaResponse(categorias, "Obtención de todas los Categorias", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new CategoriaResponse("No se encontraron Categorias", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }
    public  ResponseEntity<Object> newCategoria(Categoria categoria) {
        this.categoriaRepository.save(categoria);
        response = new CategoriaResponse(categoria, "Se pudo crear la Categoria",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);


    };

    public  ResponseEntity<Object> updateCategoria(Long id, Categoria categoria) {
        if (categoriaRepository.findById(id).isPresent()) {
            Categoria existingCategoria = categoriaRepository.findById(id).get();
            existingCategoria.setNombre(categoria.getNombre());
            categoriaRepository.save(existingCategoria);
            response = new CategoriaResponse(existingCategoria, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new CategoriaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.categoriaRepository.findById(id).isEmpty()){
            this.categoriaRepository.deleteById(id);
            response = new CategoriaResponse("Si se pudo eliminar el ID: "+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new CategoriaResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Long id){
        if (categoriaRepository.findById(id).isPresent()) {
            Categoria Categoria = categoriaRepository.findById(id).get();
            response = new CategoriaResponse(Categoria, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new CategoriaResponse("No existe la Categoria con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
