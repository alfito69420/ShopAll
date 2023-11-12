package com.example.metaphorce.controller;

import com.example.metaphorce.model.RolUsuario;
import com.example.metaphorce.service.RolUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rolUsuario")
public class RolUsuarioController {
    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getRolesUsuarios() {
        return rolUsuarioService.getRolesUsuarios();
    } //close method

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> getRolUsuario(@PathVariable Long id) {
        return this.rolUsuarioService.getOne(id);
    } //close method

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> registrarRolUsuario(@RequestBody RolUsuario rolUsuario) {
        return this.rolUsuarioService.newRolUsuario(rolUsuario);
    } //close method

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> actualizarRolUsuario(@PathVariable Long id,
                                                       @RequestBody RolUsuario rolUsuario) {
        return this.rolUsuarioService.updateRolUsuario(id, rolUsuario);
    } //close method

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Object> eliminarRolUsuario(@PathVariable Long id) {
        return this.rolUsuarioService.eliminar(id);
    } //close method
} //close class
