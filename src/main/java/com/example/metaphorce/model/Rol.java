package com.example.metaphorce.model;

public class Rol {

    private int rol_id;
    private String rol;

    public Rol(int rol_id, String rol) {
        this.rol_id = rol_id;
        this.rol = rol;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
} //close class
