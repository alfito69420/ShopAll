package com.example.metaphorce.domain;

import com.example.metaphorce.model.Tienda;
import lombok.*;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse {
    private boolean flag;
    private String message;
    private int statusCode;

}
