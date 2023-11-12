package com.example.metaphorce.controller;

import com.example.metaphorce.model.Resena;
import com.example.metaphorce.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/resena")
public class ResenaController {
    //Inyectar dependencia de Rerpository
    private final ResenaService resenaService;

    @Autowired
    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getResena() {
        return resenaService.getResena();
    } //close method

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getResena(@PathVariable Long id) {
        return this.resenaService.getOne(id);
    } //close method

    @PostMapping("/create")
    public ResponseEntity<Object> registrarResena(@RequestBody Resena resena) {
        return this.resenaService.newResena(resena);
    } //close method

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarResena(@PathVariable Long id, @RequestBody Resena resena) {
        return this.resenaService.updateResena(id, resena);
    } //close method

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarResena(@PathVariable Long id) {
        return this.resenaService.eliminarResena(id);
    } //close method
} //close class
