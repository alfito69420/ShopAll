package com.example.metaphorce.service;

import com.example.metaphorce.domain.ResenaResponse;
import com.example.metaphorce.domain.TiendaResponse;
import com.example.metaphorce.model.Resena;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ResenaService {
    private final ResenaRepository resenaRepository;
    ResenaResponse response;
    @Autowired
    public ResenaService(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }

    public ResponseEntity<Object> getResena() {
        List<Resena> resenas = resenaRepository.findAll();
        if (!resenas.isEmpty()) {
            response = new ResenaResponse(resenas, "Obtención de todas las reseñas", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No se encontraron reseñas", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newResena(Resena resena) {
        this.resenaRepository.save(resena);
        response = new ResenaResponse(resena, "Se creo la resena", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateResena(Integer id, Resena resena) {
        if (resenaRepository.findById(Long.valueOf(id)).isPresent()) {
            Resena existingResena = resenaRepository.findById(Long.valueOf(id)).get();
            existingResena.setResena(resena.getResena());
            existingResena.setCalificacion(resena.getCalificacion());
            existingResena.setProducto_id(resena.getProducto_id());
            existingResena.setUsuario_id(resena.getUsuario_id());
            resenaRepository.save(existingResena);
            response = new ResenaResponse(existingResena, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> eliminarResena(Integer id) {
        //Verificar si esta vacio
        if (!this.resenaRepository.findById(Long.valueOf(id)).isEmpty()) {
            this.resenaRepository.deleteById(Long.valueOf(id));
            response = new ResenaResponse("Si se pudo eliminar el ID:", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        if (resenaRepository.findById(Long.valueOf(id)).isPresent()) {
            Resena resena = resenaRepository.findById(Long.valueOf(id)).get();
            response = new ResenaResponse(resena, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new ResenaResponse("No existe la tienda con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
