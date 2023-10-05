package com.example.metaphorce.controller;


import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.service.TiendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> registrarTienda(@RequestBody Tienda tienda){
        return this.tiendaServices.newTienda(tienda);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> actualizarTienda(@RequestBody Tienda tienda){
        return this.tiendaServices.newTienda(tienda);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        this.tiendaServices.eliminar(id);
        return "Usuario eliminado exitosamente";
    }
    
     */
}
