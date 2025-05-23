package org.example.souchite.controllers;

import lombok.RequiredArgsConstructor;
import org.example.souchite.entities.Organisation;
import org.example.souchite.services.OrganisationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/organisations")
@RequiredArgsConstructor
public class OrganisationController {
    private final OrganisationService organisationService;

    @PostMapping
    public ResponseEntity<Organisation> creerOrganisation(@RequestBody Organisation organisation) {
        return ResponseEntity.ok(organisationService.creerOrganisation(organisation, null));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/activer")
    public ResponseEntity<Organisation> activerOrganisation(@PathVariable Long id) {
        return ResponseEntity.ok(organisationService.activerOrganisation(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/en-attente")
    public ResponseEntity<List<Organisation>> getOrganisationsEnAttente() {
        return ResponseEntity.ok(organisationService.getOrganisationsEnAttente());
    }

    @GetMapping("/activees")
    public ResponseEntity<List<Organisation>> getOrganisationsActivees() {
        return ResponseEntity.ok(organisationService.getOrganisationsActivees());
    }
} 