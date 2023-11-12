package com.example.metaphorce.service;

import com.example.metaphorce.domain.UserResponse;
import com.example.metaphorce.model.Rol;
import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.repository.RolRepository;
import com.example.metaphorce.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private UserResponse response;
    @Autowired
    private RolRepository rolRepository;

    //  Log
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getUser() {
        List<UserEntity> users = userRepository.findAll();
        if (!users.isEmpty()) {
            response = new UserResponse(users, "Obtención de todas los Users", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new UserResponse("No se encontraron Users", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> newUser(@RequestBody UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contrasenaEncriptada = passwordEncoder.encode(user.getContrasena());
        user.setContrasena(contrasenaEncriptada);

        //  Asignacion de rol por defecto: cliente
        //Rol rol = rolRepository.findByName("CLIENT").get();
        Rol rol = rolRepository.findById(Long.valueOf(3)).get();
        user.setRoles(Collections.singleton(rol));

        logger.info("Usuario Insertado: " + user);

        this.userRepository.save(user);
        response = new UserResponse(user, "Se pudo crear la User", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    } //close method

    public ResponseEntity<Object> updateUser(Long id, UserEntity user) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity existingUser = userRepository.findById(id).get();
            existingUser.setNombre(user.getNombre());
            existingUser.setEmail(user.getEmail());
            existingUser.setEmail_verificado(user.isEmail_verificado());
            existingUser.setContrasena(user.getContrasena());
            existingUser.setDireccion(user.getDireccion());
            existingUser.setTelefono(user.getTelefono());
            existingUser.setToken(user.getToken());
            existingUser.setCiudad(user.getCiudad());
            existingUser.setRoles(user.getRoles());

            logger.info("Usuario Actualizado: " + existingUser);

            userRepository.save(existingUser);
            response = new UserResponse(existingUser, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new UserResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> eliminar(Long id) {
        //Verificar si esta vacio
        if (!this.userRepository.findById(id).isEmpty()) {
            this.userRepository.deleteById(id);
            response = new UserResponse("Si se pudo eliminar el ID :" + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new UserResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method

    public ResponseEntity<Object> getOne(Long id) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity User = userRepository.findById(id).get();
            response = new UserResponse(User, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new UserResponse("No existe la User con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    } //close method
} //close class
