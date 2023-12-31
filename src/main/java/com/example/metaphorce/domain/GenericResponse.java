package com.example.metaphorce.domain;

import lombok.*;

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
