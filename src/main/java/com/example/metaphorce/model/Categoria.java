package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Table
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoria_id;
    @Column(unique = true)
    private String nombre;
}
