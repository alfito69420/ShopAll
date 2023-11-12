package com.example.metaphorce.controller;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.service.TipoPagoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tipoPago")
public class TipoPagoController {

    private final TipoPagoServices tipoPagoServices;

    public TipoPagoController(TipoPagoServices tipoPagoServices) {
        this.tipoPagoServices = tipoPagoServices;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getTipoPago() {
        return tipoPagoServices.getTipoPago();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getTipoPago(@PathVariable Long id) {
        return this.tipoPagoServices.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> registrarTipoPago(@RequestBody TipoPago tipoPago) {
        return this.tipoPagoServices.newTipoPago(tipoPago);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarTipoPago(@PathVariable Long id, @RequestBody TipoPago tipoPago) {
        return this.tipoPagoServices.updateTipoPago(id, tipoPago);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.tipoPagoServices.eliminar(id);
    } //close method
} //close class
