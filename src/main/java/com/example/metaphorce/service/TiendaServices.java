package com.example.metaphorce.service;

import com.example.metaphorce.domain.GenericResponse;
import com.example.metaphorce.model.Categoria;
import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TiendaServices {


    private final TiendaRepository tiendaRepository;

    @Autowired
    public TiendaServices(TiendaRepository tiendaRepository){
        this.tiendaRepository = tiendaRepository;
    }



    public List<Tienda> getEjemplo(){
        return List.of(
                new Tienda(
                        1,"Soriana","Tienda de mexico"
                )
        );
    }

    public List<Tienda> getTienda(){
        return tiendaRepository.findAll();
    }

    public void newTienda(Tienda tienda) {
        this.tiendaRepository.save(tienda);
    };
}
