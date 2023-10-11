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
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_venta_detalle;
    private long venta_id;
    private long producto_id;
    private int cantidad;
    private double precio;
    private double sub_total;
} //close class
