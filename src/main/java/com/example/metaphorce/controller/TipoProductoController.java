package com.example.metaphorce.controller;

import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.service.TipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tipoProducto")
public class TipoProductoController {
    private final TipoProductoServices tipoProductoServices;

    @Autowired
    public TipoProductoController(TipoProductoServices tipoProductoServices){
        this.tipoProductoServices = tipoProductoServices;
    }

    @GetMapping("/all")
    public List<TipoProducto> getTipoProducto(){
        return tipoProductoServices.getTipoProducto();
    }
}
