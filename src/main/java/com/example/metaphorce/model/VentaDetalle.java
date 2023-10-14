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
    @JoinColumn(name = "venta_id", referencedColumnName = "id_venta")
    private Venta venta;

    // Clave foránea hacia la entidad Producto
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id_producto")
    private Producto producto;
    private int cantidad;
    private double precio;
    private double sub_total;
} //close class
