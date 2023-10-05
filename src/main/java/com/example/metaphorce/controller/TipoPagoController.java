package com.example.metaphorce.controller;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.service.TipoPagoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Object> registrar(@RequestBody TipoPago tipoPago){
        return this.tipoPagoServices.newTipoPago(tipoPago);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> actualizar(@RequestBody TipoPago tipoPago){
        return this.tipoPagoServices.newTipoPago(tipoPago);
    }
}
