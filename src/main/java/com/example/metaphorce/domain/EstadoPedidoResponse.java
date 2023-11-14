package com.example.metaphorce.domain;

import com.example.metaphorce.model.EstadoPedido;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EstadoPedidoResponse extends GenericResponse {
    private EstadoPedido estadoPedido;
    private List<EstadoPedido> estadoPedidoList;
    private HashMap<String, Object> data = new HashMap<>();

    //  GET ONLY ONE RECORD
    public EstadoPedidoResponse(final EstadoPedido pEstadoPedido, final String message,
                                final int status, final boolean flag) {
        super(flag, message, status);
        this.estadoPedido = pEstadoPedido;
    }

    //  DELETE
    public EstadoPedidoResponse(final String message, final int status, final boolean flag) {
        super(flag, message, status);
    } //close method

    //  GET ALL
    public EstadoPedidoResponse(final List<EstadoPedido> pEstadoPedidoList, final String message, final int status, final boolean flag) {
        super(flag, message, status);
        this.estadoPedidoList = pEstadoPedidoList;
    } //close method

    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.estadoPedido);
        return data;
    } //close method

    public Object response2() {
        data.put("Flag", isFlag());
        data.put("Message", getMessage());
        data.put("Status", getStatusCode());
        data.put("Data", this.estadoPedidoList);
        return data;
    } //close method
} //close class
