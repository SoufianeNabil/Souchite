package org.example.souchite.mappers;

import javax.annotation.processing.Generated;
import org.example.souchite.dto.DonDTO;
import org.example.souchite.entities.ActionCharite;
import org.example.souchite.entities.Don;
import org.example.souchite.entities.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T18:23:28+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class DonMapperImpl implements DonMapper {

    @Override
    public Don toEntity(DonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Don don = new Don();

        don.setMontant( dto.getMontant() );
        don.setMessage( dto.getMessage() );

        don.setDateDon( java.time.LocalDateTime.now() );

        return don;
    }

    @Override
    public DonDTO toDto(Don don) {
        if ( don == null ) {
            return null;
        }

        DonDTO donDTO = new DonDTO();

        donDTO.setUserId( donUserId( don ) );
        donDTO.setActionChariteId( donActionChariteId( don ) );
        donDTO.setId( don.getId() );
        donDTO.setMontant( don.getMontant() );
        donDTO.setMessage( don.getMessage() );

        return donDTO;
    }

    @Override
    public void updateEntityFromDto(DonDTO dto, Don don) {
        if ( dto == null ) {
            return;
        }

        don.setMontant( dto.getMontant() );
        don.setMessage( dto.getMessage() );
    }

    private Long donUserId(Don don) {
        if ( don == null ) {
            return null;
        }
        User user = don.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long donActionChariteId(Don don) {
        if ( don == null ) {
            return null;
        }
        ActionCharite actionCharite = don.getActionCharite();
        if ( actionCharite == null ) {
            return null;
        }
        Long id = actionCharite.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
