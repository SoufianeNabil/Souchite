package org.example.souchite.mappers;

import javax.annotation.processing.Generated;
import org.example.souchite.dto.OrganisationDTO;
import org.example.souchite.entities.Organisation;
import org.example.souchite.entities.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T18:23:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class OrganisationMapperImpl implements OrganisationMapper {

    @Override
    public Organisation toEntity(OrganisationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Organisation organisation = new Organisation();

        organisation.setNom( dto.getNom() );
        organisation.setAdresse( dto.getAdresse() );
        organisation.setNif( dto.getNif() );
        organisation.setContact( dto.getContact() );

        organisation.setActive( false );

        return organisation;
    }

    @Override
    public OrganisationDTO toDto(Organisation organisation) {
        if ( organisation == null ) {
            return null;
        }

        OrganisationDTO organisationDTO = new OrganisationDTO();

        organisationDTO.setUserId( organisationUserId( organisation ) );
        organisationDTO.setId( organisation.getId() );
        organisationDTO.setNom( organisation.getNom() );
        organisationDTO.setAdresse( organisation.getAdresse() );
        organisationDTO.setNif( organisation.getNif() );
        organisationDTO.setContact( organisation.getContact() );
        organisationDTO.setActive( organisation.isActive() );

        return organisationDTO;
    }

    @Override
    public void updateEntityFromDto(OrganisationDTO dto, Organisation organisation) {
        if ( dto == null ) {
            return;
        }

        organisation.setNom( dto.getNom() );
        organisation.setAdresse( dto.getAdresse() );
        organisation.setNif( dto.getNif() );
        organisation.setContact( dto.getContact() );
    }

    private Long organisationUserId(Organisation organisation) {
        if ( organisation == null ) {
            return null;
        }
        User user = organisation.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
