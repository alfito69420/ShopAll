package com.example.metaphorce.controller;


import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.service.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tienda")
public class TiendaController {

    //Inyectar dependencia de Rerpository
    private final TiendaServices tiendaServices;
    @Autowired
    public TiendaController(TiendaServices tiendaServices){
        this.tiendaServices = tiendaServices;
    }

    @GetMapping("/ejemplo")
    public List<Tienda>getEjemplo(){
        return tiendaServices.getEjemplo();
    }

    @GetMapping("/all")
    public List<Tienda>getTienda(){
        return tiendaServices.getTienda();
    }

    @PostMapping("/create")
    public void registrarTienda(@RequestBody Tienda tienda){
        this.tiendaServices.newTienda(tienda);
    }
}
