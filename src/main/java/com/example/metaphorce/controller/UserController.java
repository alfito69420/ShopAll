package com.example.metaphorce.controller;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.User;
import com.example.metaphorce.service.UserService;
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
    public List<User> getUser(){
        return userService.getUser();
    }

    @PostMapping("/create")
    public void registrarUser(@RequestBody User user){
        this.userService.newUser(user);
    }
}
