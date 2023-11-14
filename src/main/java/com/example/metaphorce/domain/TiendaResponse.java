package com.example.metaphorce.domain;

import com.example.metaphorce.model.Tienda;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TiendaResponse extends GenericResponse {
    private Tienda tienda;
    private List<Tienda> listTienda;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public TiendaResponse(Tienda tienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.tienda = tienda;
    } //close method

    //DELETE
    public TiendaResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public TiendaResponse(List<Tienda> listTienda, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listTienda = listTienda;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tienda);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTienda);
        return datos;
    } //close method
} //close class
