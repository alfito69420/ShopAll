package com.example.metaphorce.controller;

import com.example.metaphorce.model.VentaDetalle;
import com.example.metaphorce.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ventaDetalle")
public class VentaDetalleController {

    private final VentaDetalleService ventaDetalleService;

    @Autowired
    public VentaDetalleController(VentaDetalleService ventaDetalleService) {
        this.ventaDetalleService = ventaDetalleService;
    }

    @GetMapping("/all")
    public List<VentaDetalle> getVentaDetalle() {
        return ventaDetalleService.getVentaDetalle();
    } //close method
} //close class
