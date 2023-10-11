package com.example.metaphorce.service;

import com.example.metaphorce.domain.TipoProductoResponse;
import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.repository.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TipoProductoServices {
    private final TipoProductoRepository tipoProductoRepository;
    TipoProductoResponse response;

    @Autowired
    public TipoProductoServices(TipoProductoRepository tipoProductoRepository){
        this.tipoProductoRepository = tipoProductoRepository;
    }

      public ResponseEntity<Object> getTipoProducto(){
        List<TipoProducto> tipoProductos = tipoProductoRepository.findAll();
        if (!tipoProductos.isEmpty()) {
            response = new TipoProductoResponse(tipoProductos, "Obtención de todas los TipoProductos", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new TipoProductoResponse("No se encontraron TipoProductos", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }
    public  ResponseEntity<Object> newTipoProducto(TipoProducto tipoProducto) {
        this.tipoProductoRepository.save(tipoProducto);
        response = new TipoProductoResponse(tipoProducto, "Se pudo crear la TipoProducto",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);


    };

    public  ResponseEntity<Object> updateTipoProducto(Long id, TipoProducto tipoProducto) {
        if (tipoProductoRepository.findById(id).isPresent()) {
            TipoProducto existingTipoProducto = tipoProductoRepository.findById(id).get();
            existingTipoProducto.setNombre(tipoProducto.getNombre());;
            tipoProductoRepository.save(existingTipoProducto);
            response = new TipoProductoResponse(existingTipoProducto, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TipoProductoResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object>  eliminar(Long id){
        //Verificar si esta vacio
        if(!this.tipoProductoRepository.findById(id).isEmpty()){
            this.tipoProductoRepository.deleteById(id);
            response = new TipoProductoResponse("Si se pudo eliminar el ID :"+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new TipoProductoResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Long id){
        if (tipoProductoRepository.findById(id).isPresent()) {
            TipoProducto TipoProducto = tipoProductoRepository.findById(id).get();
            response = new TipoProductoResponse(TipoProducto, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TipoProductoResponse("No existe la TipoProducto con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
