package com.example.metaphorce.service;

import com.example.metaphorce.model.Pedido;
import com.example.metaphorce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> getPedido() {
        return this.pedidoRepository.findAll();
    } //close method
} //close class
