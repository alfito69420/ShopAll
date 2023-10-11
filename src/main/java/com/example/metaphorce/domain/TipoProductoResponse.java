package com.example.metaphorce.domain;

import com.example.metaphorce.model.TipoProducto;
import java.util.HashMap;
import java.util.List;

public class TipoProductoResponse extends GenericResponse{
    private TipoProducto tipoProducto;
    private List<TipoProducto> listTipoProducto;
    HashMap<String,Object> datos = new HashMap<>();
    //GET ONE POST PATCH
    public TipoProductoResponse(TipoProducto tipoProducto, String message, int status, boolean flag){
        super(flag, message, status);
        this.tipoProducto=tipoProducto;

    }
    //DELETE
    public TipoProductoResponse(String message,int status,boolean flag){
        super(flag, message, status);

    }

    //GET All
    public TipoProductoResponse(List<TipoProducto> listTipoProducto,String message, int status, boolean flag){
        super(flag, message, status);
        this.listTipoProducto=listTipoProducto;

    }
    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tipoProducto);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTipoProducto);
        return datos;
    }
}
