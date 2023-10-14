package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class NotificacionPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificacion_pedido_id;
    private String mensaje;
    private Date fecha_hora_creacion;
    private Long pedido_id;
    private Long estado_pedido_id;
    private Long usuario_id;
} //close class

