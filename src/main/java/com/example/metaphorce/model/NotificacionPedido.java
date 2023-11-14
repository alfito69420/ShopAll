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
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "estado_pedido_id")
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity user;
} //close class

