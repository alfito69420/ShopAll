package com.example.metaphorce.domain;

        import java.util.HashMap;
        import java.util.List;

        import com.example.metaphorce.model.Rol;

        import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RolResponse extends GenericResponse {
    private Rol rol;
    private List<Rol> listRol;
    HashMap<String,Object> datos = new HashMap<>();

    //GET ONE POST PATCH
    public RolResponse(Rol rol, String message, int status, boolean flag){
        super(flag, message, status);
        this.rol = rol;
    }

    //DELETE
    public RolResponse(String message, int status, boolean flag){
        super(flag, message, status);
    }

    //GET All
    public RolResponse(List<Rol> listRol, String message, int status, boolean flag){
        super(flag, message, status);
        this.listRol = listRol;
    }

    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.rol);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listRol);
        return datos;
    }
}
