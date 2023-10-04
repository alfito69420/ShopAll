package com.example.metaphorce.controller;

import com.example.metaphorce.model.EstadoPedido;
import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.service.EstadoPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/estadoPedido")
public class EstadoPedidoController {
    private final EstadoPedidoService estadoPedidoService;

    @Autowired
    public EstadoPedidoController(EstadoPedidoService estadoPedidoService) {
        this.estadoPedidoService = estadoPedidoService;
    }

    @GetMapping("/all")
    public List<EstadoPedido> getEstadoPedido() {
        return estadoPedidoService.getEstadoPedido();
    } //close method
} //close class
