package org.example.souchite.controllers;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.ConnexionDTO;
import org.example.souchite.dto.InscriptionDTO;
import org.example.souchite.entities.User;
import org.example.souchite.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/inscription")
    public ResponseEntity<User> inscription(@Valid @RequestBody InscriptionDTO inscriptionDTO) {
        User user = userService.inscrire(inscriptionDTO);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/connexion")
    public ResponseEntity<String> connexion(@Valid @RequestBody ConnexionDTO connexionDTO) {
        // La logique de connexion sera gérée par Spring Security
        return ResponseEntity.ok("Connexion réussie");
    }
} 