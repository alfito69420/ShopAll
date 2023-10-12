package com.example.metaphorce.controller;

import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ventaDetalle")
public class VentaDetalleController {

    private final VentaDetalleService ventaDetalleService;

    @Autowired
    public VentaDetalleController(final VentaDetalleService ventaDetalleService) {
        this.ventaDetalleService = ventaDetalleService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllVentaDetalle() {
        return ventaDetalleService.getVentaDetalle();
    } //close method

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOneVentaDetalle(@PathVariable final Long id) {
        return this.ventaDetalleService.getOneVentaDetalle(id);
    } //close method

    @PostMapping("/create")
    public ResponseEntity<Object> insertVentaDetalle(@RequestBody final VentaDetalle ventaDetalle) {
        return this.ventaDetalleService.insertVentaDetalle(ventaDetalle);
    } //close method

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateVentaDetalle(@PathVariable final Long id, @RequestBody final VentaDetalle ventaDetalle) {
        return this.ventaDetalleService.updateVentaDetalle(id, ventaDetalle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteVentaDetalle(@PathVariable final Long id) {
        return this.ventaDetalleService.deleteVentaDetalle(id);
    } //close method
} //close class
