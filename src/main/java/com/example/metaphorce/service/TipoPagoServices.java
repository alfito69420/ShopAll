package com.example.metaphorce.service;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.repository.TipoPagoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TipoPagoServices {
    private final TipoPagoRepository tipoPagoRepository;
    HashMap<String,Object> datos = new HashMap<>();

    public  TipoPagoServices(TipoPagoRepository tipoPagoRepository){
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public List<TipoPago> getTipoPago(){
        return tipoPagoRepository.findAll();
    }

    public ResponseEntity<Object> newTipoPago(TipoPago tipoPago) {
        this.tipoPagoRepository.save(tipoPago);
        datos.put("Data", tipoPago);
        datos.put("Message","Se pudo crear");
        datos.put("Status",201);
        datos.put("Flag","true");
        if(tipoPago.getTipo_pago_id() > 0){
            datos.put("Message","Se pudo actualizar");
        }
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    };
}
