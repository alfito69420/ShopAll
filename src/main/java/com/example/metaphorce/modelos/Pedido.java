package com.example.metaphorce.modelos;

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
public class Pedido {
    private int usuario_id;
    private int tienda_id;
    private String fecha;
    private int venta_id;
}
