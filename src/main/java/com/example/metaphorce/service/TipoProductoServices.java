package com.example.metaphorce.service;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TipoProductoServices {
    private final TipoProductoRepository tipoProductoRepository;
    HashMap<String,Object> datos = new HashMap<>();

    @Autowired
    public TipoProductoServices(TipoProductoRepository tipoProductoRepository){
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public List<TipoProducto> getTipoProducto(){
        return tipoProductoRepository.findAll();
    }

    public ResponseEntity<Object> newTipoProducto(TipoProducto tipoProducto) {
        this.tipoProductoRepository.save(tipoProducto);
        datos.put("Data", tipoProducto);
        datos.put("Message","Se pudo crear");
        datos.put("Status",201);
        datos.put("Flag","true");
        if(tipoProducto.getTipo_id() > 0){
            datos.put("Message","Se pudo actualizar");
        }
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    };
}
