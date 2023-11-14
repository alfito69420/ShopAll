package com.example.metaphorce.domain;

import com.example.metaphorce.model.Resena;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResenaResponse extends GenericResponse {
    private Resena resena;
    private List<Resena> listResena;
    private HashMap<String, Object> datos = new HashMap<>();

    public ResenaResponse(Resena resena, String message, int status, boolean flag) {
        super(flag, message, status);
        this.resena = resena;
    }

    //DELETE
    public ResenaResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public ResenaResponse(List<Resena> listResena, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listResena = listResena;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.resena);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listResena);
        return datos;
    } //close method
} //close class
