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
    // Clave foránea hacia la entidad Venta
    @ManyToOne
    @JoinColumn(name = "venta_id", referencedColumnName = "venta_id")
    private Venta venta;

    // Clave foránea hacia la entidad Producto
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    private Producto producto;

    private int cantidad;
    private float precio;
    private float sub_total;
} //close class
