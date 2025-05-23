package org.example.souchite.services;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.InscriptionDTO;
import org.example.souchite.entities.User;
import org.example.souchite.entities.Role;
import org.example.souchite.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User inscrire(InscriptionDTO inscriptionDTO) {
        if (userRepository.existsByEmail(inscriptionDTO.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé");
        }

        User user = new User();
        user.setNom(inscriptionDTO.getNom());
        user.setEmail(inscriptionDTO.getEmail());
        user.setPassword(passwordEncoder.encode(inscriptionDTO.getPassword()));
        user.setTelephone(inscriptionDTO.getTelephone());
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }
} 