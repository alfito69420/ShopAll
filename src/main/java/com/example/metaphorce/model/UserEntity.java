package com.example.metaphorce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuario_id;

    @NotBlank
    @Size(max = 30)
    private String nombre;

    @Email
    @NotBlank
    @Size(max = 80)
    private String email;
    private boolean email_verificado;

    @NotBlank
    private String contrasena;
    private String direccion;
    private String telefono;
    private String token;
    private String ciudad;

    //  Descomentar
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Rol.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "rol_usuario",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "rol_id"))
    private Set<Rol> roles;
}
