package com.example.metaphorce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venta_id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "tipo_pago_id")
    private TipoPago tipoPago;
}
