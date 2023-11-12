package com.example.metaphorce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/roles")
public class TestRolesController {

    @GetMapping("/accessAdmin")
    public String accessAdmin() {
        return "Has accedido como admin";
    } //close method

    @GetMapping("/accessUser")
    public String accessUser() {
        return "Has accedido como user";
    } //close method

    @GetMapping("/accessInvited")
    public String accessInvited() {
        return "Has accedido como invitado";
    } //close method
} //close class
