package com.example.metaphorce.domain;

import com.example.metaphorce.model.RolUsuario;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RolUsuarioResponse extends GenericResponse {
    private RolUsuario rolUsuario;
    private List<RolUsuario> listRolUsuario;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public RolUsuarioResponse(RolUsuario rolUsuario, String message, int status, boolean flag) {
        super(flag, message, status);
        this.rolUsuario = rolUsuario;
    } //close method

    //DELETE
    public RolUsuarioResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public RolUsuarioResponse(List<RolUsuario> listRolUsuario, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listRolUsuario = listRolUsuario;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.rolUsuario);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listRolUsuario);
        return datos;
    } //close method
} //close class
