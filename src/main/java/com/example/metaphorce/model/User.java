package com.example.metaphorce.model;

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
public class User {
    private String nombre;
    private String email;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String token;
}
