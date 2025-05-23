package org.example.souchite.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.souchite.dto.ActionChariteDTO;
import org.example.souchite.entities.ActionCharite;
import org.example.souchite.entities.Organisation;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T18:23:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ActionChariteMapperImpl implements ActionChariteMapper {

    @Override
    public ActionCharite toEntity(ActionChariteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ActionCharite.ActionChariteBuilder actionCharite = ActionCharite.builder();

        actionCharite.categorie( dto.getCategorie() );
        List<String> list = dto.getMedias();
        if ( list != null ) {
            actionCharite.medias( new ArrayList<String>( list ) );
        }
        actionCharite.id( dto.getId() );
        actionCharite.titre( dto.getTitre() );
        actionCharite.description( dto.getDescription() );
        actionCharite.dateDebut( dto.getDateDebut() );
        actionCharite.dateFin( dto.getDateFin() );
        actionCharite.lieu( dto.getLieu() );
        actionCharite.objectifMontant( dto.getObjectifMontant() );
        actionCharite.montantActuel( dto.getMontantActuel() );

        return actionCharite.build();
    }

    @Override
    public ActionChariteDTO toDto(ActionCharite actionCharite) {
        if ( actionCharite == null ) {
            return null;
        }

        ActionChariteDTO actionChariteDTO = new ActionChariteDTO();

        actionChariteDTO.setOrganisationId( actionChariteOrganisationId( actionCharite ) );
        actionChariteDTO.setCategorie( actionCharite.getCategorie() );
        List<String> list = actionCharite.getMedias();
        if ( list != null ) {
            actionChariteDTO.setMedias( new ArrayList<String>( list ) );
        }
        actionChariteDTO.setId( actionCharite.getId() );
        actionChariteDTO.setTitre( actionCharite.getTitre() );
        actionChariteDTO.setDescription( actionCharite.getDescription() );
        actionChariteDTO.setDateDebut( actionCharite.getDateDebut() );
        actionChariteDTO.setDateFin( actionCharite.getDateFin() );
        actionChariteDTO.setLieu( actionCharite.getLieu() );
        actionChariteDTO.setObjectifMontant( actionCharite.getObjectifMontant() );
        actionChariteDTO.setMontantActuel( actionCharite.getMontantActuel() );

        return actionChariteDTO;
    }

    @Override
    public void updateEntityFromDto(ActionChariteDTO dto, ActionCharite actionCharite) {
        if ( dto == null ) {
            return;
        }

        actionCharite.setCategorie( dto.getCategorie() );
        if ( actionCharite.getMedias() != null ) {
            List<String> list = dto.getMedias();
            if ( list != null ) {
                actionCharite.getMedias().clear();
                actionCharite.getMedias().addAll( list );
            }
            else {
                actionCharite.setMedias( null );
            }
        }
        else {
            List<String> list = dto.getMedias();
            if ( list != null ) {
                actionCharite.setMedias( new ArrayList<String>( list ) );
            }
        }
        actionCharite.setId( dto.getId() );
        actionCharite.setTitre( dto.getTitre() );
        actionCharite.setDescription( dto.getDescription() );
        actionCharite.setDateDebut( dto.getDateDebut() );
        actionCharite.setDateFin( dto.getDateFin() );
        actionCharite.setLieu( dto.getLieu() );
        actionCharite.setObjectifMontant( dto.getObjectifMontant() );
        actionCharite.setMontantActuel( dto.getMontantActuel() );
    }

    private Long actionChariteOrganisationId(ActionCharite actionCharite) {
        if ( actionCharite == null ) {
            return null;
        }
        Organisation organisation = actionCharite.getOrganisation();
        if ( organisation == null ) {
            return null;
        }
        Long id = organisation.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
