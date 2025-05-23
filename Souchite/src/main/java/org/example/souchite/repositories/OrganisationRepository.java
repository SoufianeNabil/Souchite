package org.example.souchite.repositories;

import org.example.souchite.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    List<Organisation> findByActive(boolean active);
    boolean existsByNif(String nif);
} 