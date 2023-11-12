package com.example.metaphorce.controller;


import com.example.metaphorce.model.TipoProducto;
import com.example.metaphorce.service.TipoProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tipoProducto")
public class TipoProductoController {
    private final TipoProductoServices tipoProductoServices;

    @Autowired
    public TipoProductoController(TipoProductoServices tipoProductoServices) {
        this.tipoProductoServices = tipoProductoServices;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getTipoProducto() {
        return tipoProductoServices.getTipoProducto();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasAnyRole('Admin','Comprador')")
    public ResponseEntity<Object> getTipoProducto(@PathVariable Long id) {
        return this.tipoProductoServices.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> registrarTipoProducto(@RequestBody TipoProducto tipoProducto) {
        return this.tipoProductoServices.newTipoProducto(tipoProducto);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarTipoProducto(@PathVariable Long id,
                                                         @RequestBody TipoProducto tipoProducto) {
        return this.tipoProductoServices.updateTipoProducto(id, tipoProducto);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
        return this.tipoProductoServices.eliminar(id);
    } //close method
} //close class
