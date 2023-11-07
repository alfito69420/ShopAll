package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuario_id;
    private String nombre;
    private String email;
    private boolean email_verificado;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String token;
    private String ciudad;

    //  Descomentar
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rol_usuario",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
    private List<Rol> roles;
}
