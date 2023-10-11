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

public class Resena {
    private Long resena_id, producto_id, usuario_id;
    private String resena;
    private Integer calificacion;
}
