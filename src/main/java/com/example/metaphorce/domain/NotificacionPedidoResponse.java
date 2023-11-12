package com.example.metaphorce.domain;

import com.example.metaphorce.model.NotificacionPedido;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NotificacionPedidoResponse extends GenericResponse {
    private NotificacionPedido notificacionPedido;
    private List<NotificacionPedido> listNotificacionPedido;
    private HashMap<String, Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public NotificacionPedidoResponse(NotificacionPedido notificacionPedido, String message,
                                      int status, boolean flag) {
        super(flag, message, status);
        this.notificacionPedido = notificacionPedido;
    }

    //DELETE
    public NotificacionPedidoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    //GET All
    public NotificacionPedidoResponse(List<NotificacionPedido> listNotificacionPedido, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listNotificacionPedido = listNotificacionPedido;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.notificacionPedido);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listNotificacionPedido);
        return datos;
    } //close method
} //close class
