package com.example.metaphorce.modelos;

public class Pedido {

    private Long usuarioId;
    private Long tiendaId;
    private Long pedidoId;
    private String fechaPedido;

    public Pedido(Long usuarioId, Long tiendaId, Long pedidoId, String fechaPedido) {
        this.usuarioId = usuarioId;
        this.tiendaId = tiendaId;
        this.pedidoId = pedidoId;
        this.fechaPedido = fechaPedido;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(Long tiendaId) {
        this.tiendaId = tiendaId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
} //close class
