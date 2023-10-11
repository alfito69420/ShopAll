package com.example.metaphorce.service;
import com.example.metaphorce.domain.TiendaResponse;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class TiendaServices {
    private final TiendaRepository tiendaRepository;
    TiendaResponse response;
    @Autowired
    public TiendaServices(TiendaRepository tiendaRepository){
        this.tiendaRepository = tiendaRepository;
    }
    public ResponseEntity<Object> getTienda(){
        List<Tienda> tiendas = tiendaRepository.findAll();
        if (!tiendas.isEmpty()) {
            response = new TiendaResponse(tiendas, "Obtención de todas las tiendas", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new TiendaResponse("No se encontraron tiendas", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }
    public  ResponseEntity<Object> newTienda(Tienda tienda) {
        if(tienda.getTienda_id() > 0){
            this.tiendaRepository.save(tienda);
            response = new TiendaResponse(tienda, "Se pudo actualizar",201,true );
            return new ResponseEntity<>(response.response(), HttpStatus.CREATED);
        }else{
            this.tiendaRepository.save(tienda);
            response = new TiendaResponse(tienda, "Se pudo crear la tienda",200,true );
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }

    };

    public ResponseEntity<Object>  eliminar(Integer id){
        //Verificar si esta vacio
        if(!this.tiendaRepository.findById(id).isEmpty()){
            this.tiendaRepository.deleteById(id);
            response = new TiendaResponse("Si se pudo eliminar el ID:",200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new TiendaResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(Integer id){
        if (tiendaRepository.findById(id).isPresent()) {
            Tienda tienda = tiendaRepository.findById(id).get();
            response = new TiendaResponse(tienda, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new TiendaResponse("No existe la tienda con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }

}
