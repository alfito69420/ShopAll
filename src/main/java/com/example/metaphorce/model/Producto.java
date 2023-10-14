package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id")
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name = "tienda_id", referencedColumnName = "tienda_id")
    private Tienda tienda;

    private String nombre, descripcion, photo;
    private Float precio;
    private Integer cantidad;
}
