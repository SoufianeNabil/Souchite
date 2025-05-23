package org.example.souchite.mappers;

import org.example.souchite.dto.ActionChariteDTO;
import org.example.souchite.entities.ActionCharite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ActionChariteMapper {
    @Mapping(target = "organisation", ignore = true)
    @Mapping(target = "dons", ignore = true)
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "medias", source = "medias")
    ActionCharite toEntity(ActionChariteDTO dto);

    @Mapping(target = "organisationId", source = "organisation.id")
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "medias", source = "medias")
    ActionChariteDTO toDto(ActionCharite actionCharite);

    @Mapping(target = "organisation", ignore = true)
    @Mapping(target = "dons", ignore = true)
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "medias", source = "medias")
    void updateEntityFromDto(ActionChariteDTO dto, @MappingTarget ActionCharite actionCharite);
} 