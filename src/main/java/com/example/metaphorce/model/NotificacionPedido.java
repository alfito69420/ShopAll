package com.example.metaphorce.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NotificacionPedido {
    private Long notificacion_pedido_id;
    private String mensaje;
    private Date fecha_hora_creacion;
    private Long pedido_id;
    private Long estado_pedido_id;
    private Long usuario_id;
} //close class

