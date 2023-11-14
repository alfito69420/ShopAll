package com.example.metaphorce.domain;

import java.util.HashMap;

public class AuthResponse extends GenericResponse {
    private String token;
    private HashMap<String, Object> datos = new HashMap<>();

    public AuthResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    }

    public AuthResponse(String message, int status, boolean flag, String token) {
        super(flag, message, status);
        this.token = token;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", "No hay");
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.token);
        return datos;
    } //close method
} //close class
