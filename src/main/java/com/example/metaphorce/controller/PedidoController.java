package com.example.metaphorce.controller;

import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @GetMapping("/all")
    public List<Pedido> getPedido() {
        return pedidoService.getPedido();
    } //close class
} //close class
