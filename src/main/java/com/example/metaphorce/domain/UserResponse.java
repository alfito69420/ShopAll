package com.example.metaphorce.domain;


import java.util.HashMap;
import java.util.List;

import com.example.metaphorce.model.UserImpl;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse extends  GenericResponse{
    private UserImpl user;
    private List<UserImpl> listUser;
    HashMap<String,Object> datos = new HashMap<>();
    //GET ONE POST PATCH
    public UserResponse(UserImpl user, String message, int status, boolean flag){
        super(flag, message, status);
        this.user=user;

    }
    //DELETE
    public UserResponse(String message,int status,boolean flag){
        super(flag, message, status);

    }

    //GET All
    public UserResponse(List<UserImpl> listUser, String message, int status, boolean flag){
        super(flag, message, status);
        this.listUser=listUser;

    }
    public Object response() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.user);
        return datos;
    }

    public Object response2() {
        datos.put("Flag", isFlag());
        datos.put("Message", getMessage());
        datos.put("Status", getStatusCode());
        datos.put("Data", this.listUser);
        return datos;
    }
}
