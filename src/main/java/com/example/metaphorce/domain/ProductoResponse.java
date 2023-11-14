package com.example.metaphorce.domain;

import com.example.metaphorce.model.Producto;
import lombok.*;

import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductoResponse extends GenericResponse {
    private Producto producto;
    private List<Producto> listProducto;
    private HashMap<String, Object> datos = new HashMap<>();

    public ProductoResponse(Producto producto, String message, int status, boolean flag) {
        super(flag, message, status);
        this.producto = producto;
    }

    public ProductoResponse(String message, int status, boolean flag) {
        super(flag, message, status);
    } //close method

    public ProductoResponse(List<Producto> listProducto, String message, int status, boolean flag) {
        super(flag, message, status);
        this.listProducto = listProducto;
    } //close method

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.producto);
        return datos;
    } //close method

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listProducto);
        return datos;
    } //close method
} //close class
