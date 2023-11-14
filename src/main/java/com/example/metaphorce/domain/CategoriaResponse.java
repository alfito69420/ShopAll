package com.example.metaphorce.domain;

import com.example.metaphorce.model.Categoria;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoriaResponse extends GenericResponse {
    private Categoria categoria;
    private List<Categoria> listCategoria;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public CategoriaResponse(Categoria categoria, String message, int status, boolean flag) {
        super(flag, message, status);
        this.categoria = categoria;
    } //close method

    //DELETE
    public CategoriaResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public CategoriaResponse(List<Categoria> listCategoria, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listCategoria = listCategoria;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.categoria);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listCategoria);
        return datos;
    } //close method
} //close class
