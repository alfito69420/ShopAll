package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tienda_id;
    private String nombre;
    private String descripcion;
}
