package com.example.metaphorce.controller;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.service.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tienda")
public class TiendaController {

    //Inyectar dependencia de Rerpository
    private final TiendaServices tiendaServices;

    @Autowired
    public TiendaController(TiendaServices tiendaServices) {
        this.tiendaServices = tiendaServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getTienda() {
        return tiendaServices.getTienda();
    } //close method

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getTienda(@PathVariable Integer id) {
        return this.tiendaServices.getOne(id);
    } //close method

    @PostMapping("/create")
    public ResponseEntity<Object> registrarTienda(@RequestBody Tienda tienda) {
        return this.tiendaServices.newTienda(tienda);
    } //close method

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarTienda(@PathVariable Integer id, @RequestBody Tienda tienda) {
        return this.tiendaServices.updateTienda(id, tienda);
    } //close method

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Integer id) {
        return this.tiendaServices.eliminar(id);
    } //close method
} //close class
