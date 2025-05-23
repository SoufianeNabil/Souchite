package org.example.souchite.services;

import lombok.RequiredArgsConstructor;
import org.example.souchite.dto.ActionChariteDTO;
import org.example.souchite.entities.ActionCharite;
import org.example.souchite.entities.CategorieAction;
import org.example.souchite.entities.Organisation;
import org.example.souchite.mappers.ActionChariteMapper;
import org.example.souchite.repositories.ActionChariteRepository;
import org.example.souchite.repositories.OrganisationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActionChariteService {
    private final ActionChariteRepository actionChariteRepository;
    private final OrganisationRepository organisationRepository;
    private final ActionChariteMapper actionChariteMapper;

    public List<ActionChariteDTO> getAll() {
        return actionChariteRepository.findAll().stream()
                .map(actionChariteMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ActionChariteDTO> getByOrganisation(Long organisationId) {
        return actionChariteRepository.findByOrganisationId(organisationId).stream()
                .map(actionChariteMapper::toDto)
                .collect(Collectors.toList());
    }

    public ActionChariteDTO getById(Long id) {
        return actionChariteRepository.findById(id)
                .map(actionChariteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Action de charité non trouvée"));
    }

    @Transactional
    public ActionChariteDTO create(ActionChariteDTO dto) {
        validateCategorie(dto.getCategorie());
        Organisation organisation = organisationRepository.findById(dto.getOrganisationId())
                .orElseThrow(() -> new RuntimeException("Organisation non trouvée"));
        ActionCharite action = actionChariteMapper.toEntity(dto);
        action.setOrganisation(organisation);
        action.setMontantActuel(java.math.BigDecimal.ZERO);
        return actionChariteMapper.toDto(actionChariteRepository.save(action));
    }

    @Transactional
    public ActionChariteDTO update(Long id, ActionChariteDTO dto) {
        validateCategorie(dto.getCategorie());
        ActionCharite action = actionChariteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Action de charité non trouvée"));
        actionChariteMapper.updateEntityFromDto(dto, action);
        return actionChariteMapper.toDto(actionChariteRepository.save(action));
    }

    @Transactional
    public void delete(Long id) {
        actionChariteRepository.deleteById(id);
    }

    private void validateCategorie(CategorieAction categorie) {
        if (categorie == null) {
            throw new RuntimeException("La catégorie est obligatoire");
        }
    }
} 