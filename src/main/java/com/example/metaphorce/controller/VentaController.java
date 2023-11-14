package com.example.metaphorce.controller;

import com.example.metaphorce.model.Venta;
import com.example.metaphorce.service.VentaServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/venta")
public class VentaController {
    private final VentaServices ventaServices;

    //  Log
    private static final Logger logger = LoggerFactory.getLogger(VentaController.class);

    @Autowired
    public VentaController(VentaServices ventaServices) {
        this.ventaServices = ventaServices;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('Admin','Supplier','Comprador')")
    public ResponseEntity<Object> getVenta() {
        return ventaServices.getVenta();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAnyRole('Admin','Supplier','Comprador')")
    public ResponseEntity<Object> getVenta(@PathVariable Long id) {
        return this.ventaServices.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> registrarVenta(@RequestBody Venta venta) {
        logger.info("Venta Nueva: " + venta);
        return this.ventaServices.newVenta(venta);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarVenta(@PathVariable Long id, @RequestBody Venta venta) {
        logger.info("Venta Nueva: " + venta + ", con el ID: " + id);
        return this.ventaServices.updateVenta(id, venta);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.ventaServices.eliminar(id);
    } //close method
} //close class
