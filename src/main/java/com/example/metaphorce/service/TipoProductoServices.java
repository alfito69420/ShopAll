package com.example.metaphorce.service;

import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoProductoServices {
    private final TipoProductoRepository tipoProductoRepository;

    @Autowired
    public TipoProductoServices(TipoProductoRepository tipoProductoRepository){
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public List<TipoProducto> getTipoProducto(){
        return tipoProductoRepository.findAll();
    }
}
