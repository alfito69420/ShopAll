package com.example.metaphorce.controller;

import com.example.metaphorce.model.EstadoPedido;
import com.example.metaphorce.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/estadoPedido")
public class EstadoPedidoController {
    private final EstadoPedidoService estadoPedidoService;

    @Autowired
    public EstadoPedidoController(final EstadoPedidoService pEstadoPedidoService) {
        this.estadoPedidoService = pEstadoPedidoService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getEstadoPedido() {
        return estadoPedidoService.getEstadoPedido();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getOneEstadoPedido(@PathVariable final Long id) {
        return this.estadoPedidoService.getOneEstadoPedido(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> insertEstadoPedido(@RequestBody final EstadoPedido estadoPedido) {
        return this.estadoPedidoService.insertEstadoPedido(estadoPedido);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> updateEstadoPedido(@PathVariable final Long id,
                                                     @RequestBody final EstadoPedido estadoPedido) {
        return this.estadoPedidoService.updateEstadoPedido(id, estadoPedido);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> deleteEstadoPedido(@PathVariable final Long id) {
        return this.estadoPedidoService.deleteEstadoPedido(id);
    } //close method
} //close class
