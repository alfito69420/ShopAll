package com.example.metaphorce.modelos;

public class VentaDetalle {

    private Long ventaId;
    private Long ventaDetalleId;
    private Long productoId;
    private double cantidad;
    private double precio;
    private double subtotal;

    public VentaDetalle(Long ventaId, Long ventaDetalleId, Long productoId, double cantidad, double precio, double subtotal) {
        this.ventaId = ventaId;
        this.ventaDetalleId = ventaDetalleId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }

    public Long getVentaDetalleId() {
        return ventaDetalleId;
    }

    public void setVentaDetalleId(Long ventaDetalleId) {
        this.ventaDetalleId = ventaDetalleId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
} //close class
