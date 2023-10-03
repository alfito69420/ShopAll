package com.example.metaphorce.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pedido {
    private Long usuarioId;
    private Long tiendaId;
    private Long pedidoId;
    private String fechaPedido;
} //close class

