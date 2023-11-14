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
    public VentaResponse(final Venta pVenta, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.venta = pVenta;
    } //close method

    //DELETE
    public VentaResponse(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public VentaResponse(final List<Venta> pListVenta, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.listVenta = pListVenta;
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
