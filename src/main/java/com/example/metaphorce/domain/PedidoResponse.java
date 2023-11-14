package com.example.metaphorce.domain;

import com.example.metaphorce.model.Pedido;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PedidoResponse extends GenericResponse {
    private Pedido pedido;
    private List<Pedido> pedidoList;
    private HashMap<String, Object> data = new HashMap<>();

    //  GET ONLY ONE RECORD
    public PedidoResponse(final Pedido pedido, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.pedido = pedido;
    } //close method

    //  DELETE
    public PedidoResponse(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    } //close method

    //  GET ALL
    public PedidoResponse(final List<Pedido> pedidoList, final String message,
                          final int status, final boolean flag) {
        super(flag, message, status);
        this.pedidoList = pedidoList;
    } //close method

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.pedido);
        return data;
    } //close method

    public Object response2() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.pedidoList);
        return data;
    } //close method
} //close class
