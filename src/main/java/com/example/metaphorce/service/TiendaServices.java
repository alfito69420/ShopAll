package com.example.demo.service;

import com.example.demo.model.Tienda;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TiendaServices {

    public List<Tienda> getTienda(){
        return List.of(
                new Tienda(
                        "Soriana","Tienda de mexico"
                )
        );
    }
}
