package com.example.metaphorce.service;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.User;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    private  final UserRepository userRepository;
    HashMap<String,Object> datos = new HashMap<>();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public ResponseEntity<Object>  newUser(User user) {
        this.userRepository.save(user);
        datos.put("Data", user);
        datos.put("Message","Se pudo crear");
        datos.put("Status",201);
        datos.put("Flag","true");
        if(user.getUsuario_id() > 0){
            datos.put("Message","Se pudo actualizar");
        }
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    };
}
