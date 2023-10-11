package com.example.metaphorce.controller;

import com.example.metaphorce.model.TipoPago;
import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.service.TipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Object> registrar(@RequestBody TipoProducto tipoProducto){
        return this.tipoProductoServices.newTipoProducto(tipoProducto);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> actualizar(@RequestBody TipoProducto tipoProducto){
        return this.tipoProductoServices.newTipoProducto(tipoProducto);
    }
}
