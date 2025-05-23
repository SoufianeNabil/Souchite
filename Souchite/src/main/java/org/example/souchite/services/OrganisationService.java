package org.example.souchite.services;

import lombok.RequiredArgsConstructor;
import org.example.souchite.entities.Organisation;
import org.example.souchite.entities.User;
import org.example.souchite.repositories.OrganisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganisationService {
    private final OrganisationRepository organisationRepository;
    private final UserService userService;

    @Transactional
    public Organisation creerOrganisation(Organisation organisation, User user) {
        if (organisationRepository.existsByNif(organisation.getNif())) {
            throw new RuntimeException("Ce NIF est déjà utilisé");
        }

        organisation.setUser(user);
        organisation.setActive(false);
        return organisationRepository.save(organisation);
    }

    @Transactional
    public Organisation activerOrganisation(Long id) {
        Organisation organisation = organisationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisation non trouvée"));
        organisation.setActive(true);
        return organisationRepository.save(organisation);
    }

    public List<Organisation> getOrganisationsEnAttente() {
        return organisationRepository.findByActive(false);
    }

    public List<Organisation> getOrganisationsActivees() {
        return organisationRepository.findByActive(true);
    }
} 