package com.example.metaphorce.domain;

import com.example.metaphorce.model.Tienda;
import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse {
    private boolean flag;
    private String message;
    private int statusCode;
    private Tienda tienda;

    HashMap<String,Object> datos = new HashMap<>();

    public GenericResponse(boolean b, String sePudoCrearLaTienda, int i, Tienda tienda) {
    }


    public Object response(){
        datos.put("Flag",this.flag);
        datos.put("Message",this.message);
        datos.put("Status",this.statusCode);
        datos.put("Data", this.tienda);
        return datos;
    }
}
