package com.example.metaphorce.modelos;

public class EstadoPedido {
    private Long estadoPedidoId;
    private String nombre;

    public EstadoPedido(Long estadoPedidoId, String nombre) {
        this.estadoPedidoId = estadoPedidoId;
        this.nombre = nombre;
    }

    public Long getEstadoPedidoId() {
        return estadoPedidoId;
    }

    public void setEstadoPedidoId(Long estadoPedidoId) {
        this.estadoPedidoId = estadoPedidoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
} //close class
