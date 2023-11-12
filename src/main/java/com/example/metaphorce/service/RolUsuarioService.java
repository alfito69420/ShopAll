package com.example.metaphorce.service;

import com.example.metaphorce.domain.RolUsuarioResponse;
import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.RolUsuario;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.RolRepository;
import com.example.metaphorce.repository.RolUsuarioRepository;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {
    private final RolUsuarioRepository rolUsuarioRepository;
    private final RolRepository rolRepository;
    private final UserRepository userRepository;
    private RolUsuarioResponse response;

    public RolUsuarioService(RolUsuarioRepository rolUsuarioRepository, RolRepository rolRepository, UserRepository userRepository) {
        this.rolUsuarioRepository = rolUsuarioRepository;
        this.rolRepository = rolRepository;
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getRolesUsuarios() {
        List<RolUsuario> rolesUsuarios = rolUsuarioRepository.findAll();
        if (!rolesUsuarios.isEmpty()) {
            response = new RolUsuarioResponse(rolesUsuarios, "Obtención de todos los RolesUsuarios", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No se encontraron RolesUsuarios", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> newRolUsuario(RolUsuario rolUsuario) {
        Optional<Rol> optionalRol = rolRepository.findById(rolUsuario.getRol().getRol_id());
        Optional<UserEntity> optionalUsuario = userRepository.findById(rolUsuario.getUser().getUsuario_id());

        if (optionalRol.isPresent() && optionalUsuario.isPresent()) {
            Rol rol = optionalRol.get();
            UserEntity usuario = optionalUsuario.get();
            rolUsuario.setRol(rol);
            rolUsuario.setUser(usuario);
            this.rolUsuarioRepository.save(rolUsuario);

            response = new RolUsuarioResponse(rolUsuario, "Se pudo crear el RolUsuario", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            // Manejar el caso en el que no se encuentre una o ambas entidades
            response = new RolUsuarioResponse("No se encontró una o ambas entidades (Rol o Usuario)", 404, false);
            return new ResponseEntity<>(response.response(), HttpStatus.NOT_FOUND);
        }
    } //close method

    public ResponseEntity<Object> updateRolUsuario(Long id, RolUsuario rolUsuario) {
        Optional<RolUsuario> optionalRolUsuario = rolUsuarioRepository.findById(id);
        if (optionalRolUsuario.isPresent()) {
            RolUsuario existingRolUsuario = optionalRolUsuario.get();
            existingRolUsuario.setRol(rolUsuario.getRol());
            existingRolUsuario.setUser(rolUsuario.getUser());
            rolUsuarioRepository.save(existingRolUsuario);
            response = new RolUsuarioResponse(existingRolUsuario, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.BAD_REQUEST); // Cambiado a BAD_REQUEST para reflejar un error de cliente
        }
    } //close method

    public ResponseEntity<Object> eliminar(Long id) {
        if (!this.rolUsuarioRepository.findById(id).isEmpty()) {
            this.rolUsuarioRepository.deleteById(id);
            response = new RolUsuarioResponse("Si se pudo eliminar el ID :" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> getOne(Long id) {
        if (rolUsuarioRepository.findById(id).isPresent()) {
            RolUsuario rolUsuario = rolUsuarioRepository.findById(id).get();
            response = new RolUsuarioResponse(rolUsuario, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No existe el Rol con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method
} //close class
