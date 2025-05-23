package org.example.souchite.mappers;

import javax.annotation.processing.Generated;
import org.example.souchite.dto.InscriptionDTO;
import org.example.souchite.entities.Role;
import org.example.souchite.entities.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T18:23:29+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(InscriptionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setNom( dto.getNom() );
        user.setEmail( dto.getEmail() );
        user.setTelephone( dto.getTelephone() );

        user.setRole( Role.USER );

        return user;
    }

    @Override
    public InscriptionDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        InscriptionDTO inscriptionDTO = new InscriptionDTO();

        inscriptionDTO.setNom( user.getNom() );
        inscriptionDTO.setEmail( user.getEmail() );
        inscriptionDTO.setTelephone( user.getTelephone() );

        return inscriptionDTO;
    }

    @Override
    public void updateEntityFromDto(InscriptionDTO dto, User user) {
        if ( dto == null ) {
            return;
        }

        user.setNom( dto.getNom() );
        user.setEmail( dto.getEmail() );
        user.setTelephone( dto.getTelephone() );
    }
}
