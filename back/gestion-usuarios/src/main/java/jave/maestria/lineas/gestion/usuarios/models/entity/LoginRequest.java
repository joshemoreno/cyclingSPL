package jave.maestria.lineas.gestion.usuarios.models.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
