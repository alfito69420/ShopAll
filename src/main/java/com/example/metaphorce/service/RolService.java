package com.example.metaphorce.service;

import com.example.metaphorce.domain.RolResponse;
import com.example.metaphorce.model.Rol;
import com.example.metaphorce.repository.RolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    private final RolRepository rolRepository;
    private RolResponse response;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public ResponseEntity<Object> getRoles() {
        List<Rol> roles = rolRepository.findAll();
        if (!roles.isEmpty()) {
            response = new RolResponse(roles, "Obtención de todos los Roles", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new RolResponse("No se encontraron Roles", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> newRol(Rol rol) {
        this.rolRepository.save(rol);
        response = new RolResponse(rol, "Se pudo crear el Rol", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    } //close method

    public ResponseEntity<Object> updateRol(Long id, Rol rol) {
        if (rolRepository.findById(id).isPresent()) {
            Rol existingRol = rolRepository.findById(id).get();
            existingRol.setRol(rol.getRol());
            rolRepository.save(existingRol);
            response = new RolResponse(existingRol, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> eliminar(Long id) {
        if (!this.rolRepository.findById(id).isEmpty()) {
            this.rolRepository.deleteById(id);
            response = new RolResponse("Si se pudo eliminar el ID :" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);

        }
    } //close method

    public ResponseEntity<Object> getOne(Long id) {
        if (rolRepository.findById(id).isPresent()) {
            Rol rol = rolRepository.findById(id).get();
            response = new RolResponse(rol, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolResponse("No existe el Rol con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method
} //close method
