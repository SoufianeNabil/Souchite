package org.example.souchite.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class DonDTO {
    private Long id;

    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant doit être positif")
    private BigDecimal montant;

    private String message;

    @NotNull(message = "L'action de charité est obligatoire")
    private Long actionChariteId;

    private Long userId;
} 