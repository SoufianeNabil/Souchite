package org.example.souchite.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
public class OrganisationDTO {
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;

    @NotBlank(message = "Le NIF est obligatoire")
    @Pattern(regexp = "^[0-9]{10}$", message = "Le NIF doit contenir 10 chiffres")
    private String nif;

    private String contact;

    private boolean active;

    private Long userId;
} 