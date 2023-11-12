package com.example.metaphorce.domain;

import com.example.metaphorce.model.Venta;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VentaResponse extends GenericResponse {
    private Venta venta;
    private List<Venta> listVenta;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public VentaResponse(Venta venta, String message, int status, boolean flag) {
        super(flag, message, status);
        this.venta = venta;
    } //close method

    //DELETE
    public VentaResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public VentaResponse(List<Venta> listVenta, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listVenta = listVenta;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.venta);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listVenta);
        return datos;
    } //close method
} //close class
