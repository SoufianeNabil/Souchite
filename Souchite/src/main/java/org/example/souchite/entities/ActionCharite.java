package org.example.souchite.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actions_charite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionCharite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime dateDebut;

    private LocalDateTime dateFin;

    private String lieu;

    @Column(nullable = false)
    private BigDecimal objectifMontant;

    @Column(nullable = false)
    private BigDecimal montantActuel = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private CategorieAction categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private Organisation organisation;

    @OneToMany(mappedBy = "actionCharite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Don> dons;

    @ElementCollection
    @CollectionTable(name = "action_medias", joinColumns = @JoinColumn(name = "action_id"))
    @Column(name = "media_url")
    private List<String> medias;
}
