package com.example.metaphorce.domain;

import com.example.metaphorce.model.TipoPago;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TipoPagoResponse extends GenericResponse {
    private TipoPago tipoPago;
    private List<TipoPago> listTipoPago;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public TipoPagoResponse(TipoPago tipoPago, String message, int status, boolean flag) {
        super(flag, message, status);
        this.tipoPago = tipoPago;
    } //close method

    //DELETE
    public TipoPagoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public TipoPagoResponse(List<TipoPago> listTipoPago, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listTipoPago = listTipoPago;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.tipoPago);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listTipoPago);
        return datos;
    } //close method
} //close class
