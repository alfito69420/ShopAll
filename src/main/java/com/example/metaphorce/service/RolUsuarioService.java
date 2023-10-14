package com.example.metaphorce.service;

        import com.example.metaphorce.domain.RolUsuarioResponse;
        import com.example.metaphorce.model.RolUsuario;
        import com.example.metaphorce.repository.RolUsuarioRepository;

        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class RolUsuarioService {
    private final RolUsuarioRepository rolUsuarioRepository;
    RolUsuarioResponse response;

    public RolUsuarioService(RolUsuarioRepository rolUsuarioRepository){
        this.rolUsuarioRepository = rolUsuarioRepository;
    }

    public ResponseEntity<Object> getRolesUsuarios(){
        List<RolUsuario> rolesUsuarios = rolUsuarioRepository.findAll();
        if (!rolesUsuarios.isEmpty()) {
            response = new RolUsuarioResponse(rolesUsuarios, "Obtención de todos los RolesUsuarios", 200, true);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No se encontraron RolesUsuarios", 400, false);
            return new ResponseEntity<>(response.response2(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> newRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuarioRepository.save(rolUsuario);
        response = new RolUsuarioResponse(rolUsuario, "Se pudo crear el RolUsuario",200,true );
        return new ResponseEntity<>(response.response(), HttpStatus.OK);
    };

    public ResponseEntity<Object> updateRolUsuario(int id, RolUsuario rolUsuario) {
        if (rolUsuarioRepository.findById(id).isPresent()) {
            RolUsuario existingRolUsuario = rolUsuarioRepository.findById(id).get();
            existingRolUsuario.setRol_id(rolUsuario.getRol_id());
            existingRolUsuario.setUsuario_id(rolUsuario.getUsuario_id());
            rolUsuarioRepository.save(existingRolUsuario);
            response = new RolUsuarioResponse(existingRolUsuario, "Se pudo actualizar", 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No existe el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    };

    public ResponseEntity<Object> eliminar(int id){
        if(!this.rolUsuarioRepository.findById(id).isEmpty()){
            this.rolUsuarioRepository.deleteById(id);
            response = new RolUsuarioResponse("Si se pudo eliminar el ID :"+id,200,true );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);
        }else{
            response = new RolUsuarioResponse("No existe el ID: "+id,400,false );
            return new ResponseEntity<>(response.response(),HttpStatus.OK);

        }
    };

    public ResponseEntity<Object> getOne(int id){
        if (rolUsuarioRepository.findById(id).isPresent()) {
            RolUsuario rolUsuario = rolUsuarioRepository.findById(id).get();
            response = new RolUsuarioResponse(rolUsuario, "Si encontró el ID: " + id, 200, true);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        } else {
            response = new RolUsuarioResponse("No existe el Rol con el ID: " + id, 400, false);
            return new ResponseEntity<>(response.response(), HttpStatus.OK);
        }
    }
}
