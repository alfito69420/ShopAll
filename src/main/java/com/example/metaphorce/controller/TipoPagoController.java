package com.example.metaphorce.controller;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.service.TipoPagoServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tipoPago")
public class TipoPagoController {

    private final TipoPagoServices tipoPagoServices;

    public TipoPagoController(TipoPagoServices tipoPagoServices){
        this.tipoPagoServices= tipoPagoServices;
    }

    @GetMapping("/all")
    public List<TipoPago> getTipoPago(){
        return tipoPagoServices.getTipoPago();
    }
}
