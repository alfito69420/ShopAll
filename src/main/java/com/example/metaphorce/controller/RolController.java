package com.example.metaphorce.controller;

        import com.example.metaphorce.model.Rol;
        import com.example.metaphorce.service.RolService;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rol")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService){
        this.rolService = rolService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getRoles(){
        return rolService.getRoles();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getRol(@PathVariable int id){
        return this.rolService.getOne(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> registrarRol(@RequestBody Rol rol){
        return this.rolService.newRol(rol);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> actualizarRol(@PathVariable int id, @RequestBody Rol rol){
        return this.rolService.updateRol(id, rol);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarRol(@PathVariable int id) {
        return this.rolService.eliminar(id);
    }
}
