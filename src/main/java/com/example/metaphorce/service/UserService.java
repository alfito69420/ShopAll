package com.example.metaphorce.service;

import com.example.metaphorce.domain.UserResponse;
import com.example.metaphorce.model.UserImpl;
import com.example.metaphorce.repository.UserRepository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UserService {
    private  final UserRepository userRepository;
    UserResponse response;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   public ResponseEntity<Object> getUser(){
        List<UserImpl> users = userRepository.findAll();
        if (!users.isEmpty()) {
            response = new UserResponse(users, "Obtención de todas los Users", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new UserResponse("No se encontraron Users", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }
    public ResponseEntity<Object> newUser(UserImpl user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String contrasenaEncriptada = passwordEncoder.encode(user.getContrasena());
        user.setContrasena(contrasenaEncriptada);
        this.userRepository.save(user);
        response = new UserResponse(user, "Se pudo crear la User", 200, true);
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    }
    public  ResponseEntity<Object> updateUser(Long id, UserImpl user) {
        if (userRepository.findById(id).isPresent()) {
            UserImpl existingUser = userRepository.findById(id).get();
            existingUser.setNombre(user.getNombre());
            //existingUser.setDescripcion(user.getDescripcion());
            userRepository.save(existingUser);
            response = new UserResponse(existingUser, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new UserResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.userRepository.findById(id).isEmpty()){
            this.userRepository.deleteById(id);
            response = new UserResponse("Si se pudo eliminar el ID :"+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new UserResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Long id){
        if (userRepository.findById(id).isPresent()) {
            UserImpl User = userRepository.findById(id).get();
            response = new UserResponse(User, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new UserResponse("No existe la User con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
