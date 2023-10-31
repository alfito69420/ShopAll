package com.example.metaphorce.domain;

import com.example.metaphorce.model.Categoria;

import java.util.HashMap;

public class AuthResponse extends GenericResponse{
    HashMap<String,Object> datos = new HashMap<>();
    public AuthResponse( String message, int status, boolean flag){
        super(flag, message, status);
    }
    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", "No hay");
        return datos;
    }
}
