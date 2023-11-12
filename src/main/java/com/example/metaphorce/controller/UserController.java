package com.example.metaphorce.controller;

import com.example.metaphorce.model.UserEntity;
import com.example.metaphorce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getUser() {
        return userService.getUser();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        return this.userService.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> registrarUser(@RequestBody UserEntity user) {
        return this.userService.newUser(user);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarUser(@PathVariable Long id, @RequestBody UserEntity user) {
        return this.userService.updateUser(id, user);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.userService.eliminar(id);
    } //close method
} //close class
