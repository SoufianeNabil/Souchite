package org.example.souchite.mappers;

import org.example.souchite.entities.Don;
import org.example.souchite.dto.DonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DonMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateDon", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "actionCharite", ignore = true)
    Don toEntity(DonDTO dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "actionChariteId", source = "actionCharite.id")
    DonDTO toDto(Don don);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateDon", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "actionCharite", ignore = true)
    void updateEntityFromDto(DonDTO dto, @MappingTarget Don don);
} 