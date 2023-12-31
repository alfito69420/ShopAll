package com.example.metaphorce.controller;

import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getAllPedido() {
        return pedidoService.getPedido();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getOnePedido(@PathVariable final Long id) {
        return this.pedidoService.getOnePedido(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> insertPedido(@RequestBody final Pedido pedido) {
        return this.pedidoService.insertPedido(pedido);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> updatePedido(@PathVariable final Long id, @RequestBody final Pedido pedido) {
        return this.pedidoService.updatePedido(id, pedido);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> deletePedido(@PathVariable final Long id) {
        return this.pedidoService.deletePedido(id);
    } //close method
} //close class
