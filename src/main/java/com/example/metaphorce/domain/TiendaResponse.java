package com.example.metaphorce.domain;

import lombok.*;

import java.util.HashMap;
import java.util.List;

import com.example.metaphorce.model.Tienda;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TiendaResponse extends GenericResponse {
    private Tienda tienda;
    private List<Tienda> listTienda;
    HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public TiendaResponse(Tienda tienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.tienda = tienda;
    }

    //DELETE
    public TiendaResponse(String message, int status, boolean flag) {
        super(flag, message, status);

    }

    //GET All
    public TiendaResponse(List<Tienda> listTienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listTienda = listTienda;
    }

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tienda);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTienda);
        return datos;
    }
}
