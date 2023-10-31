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
public class Resena{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resena_id;
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UserImpl user;
    private String resena;
    private Integer calificacion;
}
