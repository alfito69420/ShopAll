package com.example.metaphorce.service;

import com.example.metaphorce.domain.GenericResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.repository.PedidoRepository;
import com.example.metaphorce.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.HashMap;
import java.util.List;

@Service
public class TiendaServices {
    private final TiendaRepository tiendaRepository;
    private final PedidoRepository pedidoRepository;
    HashMap<String,Object> datos = new HashMap<>();
    GenericResponse response;
    @Autowired
    public TiendaServices(TiendaRepository tiendaRepository, PedidoRepository pedidoRepository){
        this.tiendaRepository = tiendaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<Tienda> getTienda(){
        return tiendaRepository.findAll();
    }
    public  ResponseEntity<Object> newTienda(Tienda tienda) {
        this.tiendaRepository.save(tienda);
        datos.put("Data", tienda);
        datos.put("Message","Se pudo crear la tienda");
        datos.put("Status",201);
        datos.put("Flag","true");
        if(tienda.getTienda_id() > 0){
            datos.put("Message","Se pudo actualizar");
            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(datos, HttpStatus.OK);
        }

    };

    public ResponseEntity<Object>  eliminar(Integer id){
        //Verificar si esta vacio
        if(!this.tiendaRepository.findById(id).isEmpty()){
            if(!this.pedidoRepository.findBy())
            this.tiendaRepository.deleteAll();
            datos.put("Data", " ");
            datos.put("Message","Si se pudo eliminar el ID: "+id);
            datos.put("Status",201);
            datos.put("Flag","true");
            return new ResponseEntity<>(datos,HttpStatus.OK);
        }else{
            datos.put("Data", "");
            datos.put("Message","No existe el ID: "+id);
            datos.put("Status",400);
            datos.put("Flag","false");
            return new ResponseEntity<>(datos,HttpStatus.OK);

        }
    };

    public List<Tienda> getEjemplo(){
        return List.of(
                new Tienda(
                        1,"Soriana","Tienda de mexico"
                )
        );
    }



   /*
    public void eliminar(long id){
        this.tiendaRepository.deleteTiendaBy(id);
    }

    */
}
