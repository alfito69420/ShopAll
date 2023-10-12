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
    private int resena_id;
    private int producto_id;
    private int usuario_id;
    private String resena;
    private Integer calificacion;
}
