package com.example.metaphorce.controller;

        import com.example.metaphorce.model.RolUsuario;
        import com.example.metaphorce.service.RolUsuarioService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rolUsuario")
public class RolUsuarioController {
    private final RolUsuarioService rolUsuarioService;

    public RolUsuarioController(RolUsuarioService rolUsuarioService){
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getRolesUsuarios(){
        return rolUsuarioService.getRolesUsuarios();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getRolUsuario(@PathVariable Long id){
        return this.rolUsuarioService.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarRolUsuario(@RequestBody RolUsuario rolUsuario){
        return this.rolUsuarioService.newRolUsuario(rolUsuario);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarRolUsuario(@PathVariable Long id, @RequestBody RolUsuario rolUsuario){
        return this.rolUsuarioService.updateRolUsuario(id, rolUsuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarRolUsuario(@PathVariable Long id) {
        return this.rolUsuarioService.eliminar(id);
    }
}
