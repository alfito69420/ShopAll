package com.example.metaphorce.controller;

import com.example.metaphorce.model.Venta;
import com.example.metaphorce.service.VentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/venta")
public class VentaController {
    private final VentaServices ventaServices;

    @Autowired
    public VentaController(VentaServices ventaServices) {
        this.ventaServices = ventaServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getVenta() {
        return ventaServices.getVenta();
    } //close method

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getVenta(@PathVariable Long id) {
        return this.ventaServices.getOne(id);
    } //close method

    @PostMapping("/create")
    public ResponseEntity<Object> registrarVenta(@RequestBody Venta venta) {
        return this.ventaServices.newVenta(venta);
    } //close method

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return this.ventaServices.updateVenta(id, venta);
    } //close method

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.ventaServices.eliminar(id);
    } //close method
} //close class
