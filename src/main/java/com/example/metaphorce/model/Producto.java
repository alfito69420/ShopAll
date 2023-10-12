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
    private int producto_id;
    private Long categoria_id, tipo_id, tienda_id;
    private String nombre, descripcion, photo;
    private Float precio;
    private Integer cantidad;
}
