package com.example.demo.controller;

import com.example.demo.model.Tienda;
import com.example.demo.repository.TiendaRepository;
import com.example.demo.service.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tienda")
public class TiendaController {

    //Inyectar dependencia de Rerpository
    private final TiendaServices tiendaServices;
    private TiendaRepository tiendaRepository;

    @Autowired
    public TiendaController(TiendaServices tiendaServices){
        this.tiendaServices = tiendaServices;
    }

    @GetMapping("all")
    public List<Tienda>getTienda(){
        return tiendaServices.getTienda();
    }
    /*
    @GetMapping("/all")
    private @ResponseBody List<Tienda> getAllTienda(){
        return 0;
    }

     */




}
