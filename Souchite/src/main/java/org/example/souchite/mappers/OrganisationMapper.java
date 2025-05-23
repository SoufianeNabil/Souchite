package org.example.souchite.mappers;

import org.example.souchite.entities.Organisation;
import org.example.souchite.dto.OrganisationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrganisationMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "false")
    @Mapping(target = "actionsCharite", ignore = true)
    @Mapping(target = "user", ignore = true)
    Organisation toEntity(OrganisationDTO dto);

    @Mapping(target = "userId", source = "user.id")
    OrganisationDTO toDto(Organisation organisation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "actionsCharite", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntityFromDto(OrganisationDTO dto, @MappingTarget Organisation organisation);
} 