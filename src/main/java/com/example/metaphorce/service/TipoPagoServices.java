package com.example.metaphorce.service;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.repository.TipoPagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoServices {
    private final TipoPagoRepository tipoPagoRepository;

    public  TipoPagoServices(TipoPagoRepository tipoPagoRepository){
        this.tipoPagoRepository = tipoPagoRepository;
    }

    public List<TipoPago> getTipoPago(){
        return tipoPagoRepository.findAll();
    }
}
