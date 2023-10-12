package com.example.metaphorce.controller;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.User;
import com.example.metaphorce.model.User;
import com.example.metaphorce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public  UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/all")
    public ResponseEntity<Object>getUser(){
        return userService.getUser();
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
        return this.userService.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarUser(@RequestBody User user){
        return this.userService.newUser(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarUser(@PathVariable Long id,@RequestBody User user){
        return this.userService.updateUser(id,user);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.userService.eliminar(id);

    }
}
