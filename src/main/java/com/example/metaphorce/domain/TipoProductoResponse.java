package com.example.metaphorce.domain;

import com.example.metaphorce.model.TipoProducto;

import java.util.HashMap;
import java.util.List;

public class TipoProductoResponse extends GenericResponse {
    private TipoProducto tipoProducto;
    private List<TipoProducto> listTipoProducto;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public TipoProductoResponse(TipoProducto tipoProducto, String message, int status, boolean flag) {
        super(flag, message, status);
        this.tipoProducto = tipoProducto;
    } //close method

    //DELETE
    public TipoProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public TipoProductoResponse(List<TipoProducto> listTipoProducto, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listTipoProducto = listTipoProducto;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tipoProducto);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTipoProducto);
        return datos;
    } //close method
} //close class
