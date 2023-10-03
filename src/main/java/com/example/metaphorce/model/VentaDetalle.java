package com.example.metaphorce.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VentaDetalle {
    private Long ventaId;
    private Long ventaDetalleId;
    private Long productoId;
    private double cantidad;
    private double precio;
    private double subtotal;
} //close class
