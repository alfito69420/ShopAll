package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
@Entity(name = "rol")
@Table
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rol_id;

    //@Enumerated(EnumType.STRING)
    private String rol;
} //close class
