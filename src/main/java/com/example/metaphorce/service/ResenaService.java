package com.example.metaphorce.service;

import com.example.metaphorce.domain.ResenaResponse;
import com.example.metaphorce.model.Producto;
import com.example.metaphorce.model.Resena;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.ProductoRepository;
import com.example.metaphorce.repository.ResenaRepository;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResenaService {
    private final ResenaRepository resenaRepository;
    private final UserRepository userRepository;
    private final ProductoRepository productoRepository;
    ResenaResponse response;
    @Autowired
    public ResenaService(ResenaRepository resenaRepository, UserRepository userRepository, ProductoRepository productoRepository) {
        this.resenaRepository = resenaRepository;
        this.userRepository = userRepository;
        this. productoRepository = productoRepository;
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
        Optional<Producto> productoOptional = productoRepository.findById(resena.getProducto().getProducto_id());
        Optional<UserEntity> usuarioOptional = userRepository.findById(resena.getUser().getUsuario_id());

        if (productoOptional.isPresent() && usuarioOptional.isPresent()) {
            Producto producto = productoOptional.get();
            UserEntity usuario = usuarioOptional.get();

            resena.setProducto(producto);
            resena.setUser(usuario);

            resenaRepository.save(resena);

            response = new ResenaResponse(resena, "Se creó la reseña", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            if (!productoOptional.isPresent()) {
                response = new ResenaResponse("No existe el Producto con el ID: " + resena.getProducto().getProducto_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            } else {
                response = new ResenaResponse("No existe el Usuario con el ID: " + resena.getUser().getUsuario_id(), 400, false);
                return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
            }
        }
    }

    public ResponseEntity<Object> updateResena(long id, Resena updatedResena) {
        Optional<Resena> existingResenaOptional = resenaRepository.findById(id);

        if (existingResenaOptional.isPresent()) {
            Resena existingResena = existingResenaOptional.get();
            Optional<Producto> productoOptional = productoRepository.findById(updatedResena.getProducto().getProducto_id());
            Optional<UserEntity> usuarioOptional = userRepository.findById(updatedResena.getUser().getUsuario_id());

            if (productoOptional.isPresent() && usuarioOptional.isPresent()) {
                Producto producto = productoOptional.get();
                UserEntity usuario = usuarioOptional.get();

                existingResena.setProducto(producto);
                existingResena.setUser(usuario);
                existingResena.setResena(updatedResena.getResena());
                existingResena.setCalificacion(updatedResena.getCalificacion());

                resenaRepository.save(existingResena);

                response = new ResenaResponse(existingResena, "Se actualizó la reseña con éxito", 200, true);
                return new ResponseEntity<>(response.response(), HttpStatus.OK);
            } else {
                if (!productoOptional.isPresent()) {
                    response = new ResenaResponse("No existe el Producto con el ID: " + updatedResena.getProducto().getProducto_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                } else {
                    response = new ResenaResponse("No existe el Usuario con el ID: " + updatedResena.getUser().getUsuario_id(), 400, false);
                    return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            response = new ResenaResponse("No existe la Reseña con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> eliminarResena(Long id) {
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

    public ResponseEntity<Object> getOne(Long id) {
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
