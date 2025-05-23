package org.example.souchite.repositories;

import org.example.souchite.entities.ActionCharite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActionChariteRepository extends JpaRepository<ActionCharite, Long> {
    List<ActionCharite> findByOrganisationId(Long organisationId);
} 