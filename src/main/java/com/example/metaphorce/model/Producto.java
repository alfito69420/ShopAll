package com.example.metaphorce.model;

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

public class Producto {
    private Long producto_id, category_id, tipo_id, tienda_id;
    private String nombre, descripcion, photo;
    private Float precio;
    private Integer cantidad;
}
