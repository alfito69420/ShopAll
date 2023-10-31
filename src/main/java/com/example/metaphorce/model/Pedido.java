package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pedido_id;
    private String fecha_pedido;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserImpl user;

    @ManyToOne
    @JoinColumn(name = "tienda_id", referencedColumnName = "tienda_id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    private Venta venta;
} //close class

