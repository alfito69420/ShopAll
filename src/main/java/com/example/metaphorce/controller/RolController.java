package com.example.metaphorce.controller;

import com.example.metaphorce.model.Rol;
import com.example.metaphorce.service.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getRoles() {
        return rolService.getRoles();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getRol(@PathVariable Long id) {
        return this.rolService.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    public ResponseEntity<Object> registrarRol(@RequestBody Rol rol) {
        return this.rolService.newRol(rol);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        return this.rolService.updateRol(id, rol);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarRol(@PathVariable Long id) {
        return this.rolService.eliminar(id);
    } //close method
} //close class
