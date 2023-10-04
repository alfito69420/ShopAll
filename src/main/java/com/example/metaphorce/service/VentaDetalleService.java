package com.example.metaphorce.service;

import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;

    @Autowired
    public VentaDetalleService(VentaDetalleRepository ventaDetalleRepository) {
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    public List<VentaDetalle> getVentaDetalle() {
        return this.ventaDetalleRepository.findAll();
    } //close method
} //close class
