package com.example.metaphorce.domain;

import com.example.metaphorce.model.VentaDetalle;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VentaDetalleResponse extends GenericResponse {
    private VentaDetalle ventaDetalle;
    private List<VentaDetalle> ventaDetalleList;
    private HashMap<String, Object> data = new HashMap<>();

    //  GET ONLY ONE RECORD
    public VentaDetalleResponse(final VentaDetalle ventaDetalle, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ventaDetalle = ventaDetalle;
    }

    //  DELETE
    public VentaDetalleResponse(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    }

    //  GET ALL
    public VentaDetalleResponse(final List<VentaDetalle> ventaDetalleList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.ventaDetalleList = ventaDetalleList;
    }

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ventaDetalle);
        return data;
    } //close method

    public Object response2() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.ventaDetalleList);
        return data;
    } //close method
} //close class
