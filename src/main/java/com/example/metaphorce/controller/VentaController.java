package com.example.metaphorce.controller;

import com.example.metaphorce.model.Venta;
import com.example.metaphorce.service.VentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/venta")
public class VentaController {
    private final VentaServices ventaServices;
    @Autowired
    public VentaController(VentaServices ventaServices){
        this.ventaServices = ventaServices;
    }
    @GetMapping("/all")
    public List<Venta>getVenta(){
        return ventaServices.getVenta();
    }
    @PostMapping("/create")
    public void registrarVenta(@RequestBody Venta venta){
        this.ventaServices.newVenta(venta);
    }
}
