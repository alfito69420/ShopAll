package com.example.metaphorce.service;

import com.example.metaphorce.model.EstadoPedido;
import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.repository.EstadoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;

    @Autowired
    public EstadoPedidoService(EstadoPedidoRepository estadoPedidoRepository) {
        this.estadoPedidoRepository = estadoPedidoRepository;
    }

    public List<EstadoPedido> getEstadoPedido() {
        return this.estadoPedidoRepository.findAll();
    } //close method
} //close class
