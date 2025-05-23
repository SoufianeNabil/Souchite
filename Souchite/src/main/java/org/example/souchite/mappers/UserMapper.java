package org.example.souchite.mappers;

import org.example.souchite.dto.InscriptionDTO;
import org.example.souchite.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "dons", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(InscriptionDTO dto);

    @Mapping(target = "password", ignore = true)
    InscriptionDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "dons", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateEntityFromDto(InscriptionDTO dto, @MappingTarget User user);
} 