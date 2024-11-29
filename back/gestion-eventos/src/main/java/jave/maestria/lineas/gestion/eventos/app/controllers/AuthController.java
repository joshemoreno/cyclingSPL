package jave.maestria.lineas.gestion.eventos.app.controllers;

import jave.maestria.lineas.gestion.eventos.app.services.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String rol) {
        return jwtService.generateToken(username, rol);
    }
}