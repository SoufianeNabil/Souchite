package org.example.souchite.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false, unique = true)
    private String nif;

    private String contact;

    private boolean active = false;

    @OneToMany(mappedBy = "organisation")
    private List<ActionCharite> actionsCharite;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
} 