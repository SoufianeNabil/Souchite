package org.example.souchite.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.souchite.entities.CategorieAction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ActionChariteDTO {
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String titre;

    private String description;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String lieu;

    @NotNull(message = "L'objectif est obligatoire")
    private BigDecimal objectifMontant;
    private BigDecimal montantActuel;

    @NotNull(message = "La catégorie est obligatoire")
    private CategorieAction categorie;

    @NotNull(message = "L'organisation est obligatoire")
    private Long organisationId;

    private List<String> medias;
} 