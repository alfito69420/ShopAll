package com.example.metaphorce.security;

import lombok.Data;

/**
 * Modelo que representa las
 * credenciales del usuario a
 * autenticar
 *
 */
@Data
public class AuthCredentials {
    private String email;
    private String password;
} //close class
