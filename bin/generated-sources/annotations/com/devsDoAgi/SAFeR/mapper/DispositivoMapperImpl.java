package com.devsDoAgi.SAFeR.mapper;

import com.devsDoAgi.SAFeR.dto.DispositivoRequestDTO;
import com.devsDoAgi.SAFeR.dto.DispositivoResponseDTO;
import com.devsDoAgi.SAFeR.enums.DispositivoStatus;
import com.devsDoAgi.SAFeR.enums.DispositivoTipos;
import com.devsDoAgi.SAFeR.model.Dispositivo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T09:33:46-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class DispositivoMapperImpl implements DispositivoMapper {

    @Override
    public Dispositivo toEntity(DispositivoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Dispositivo dispositivo = new Dispositivo();

        Double[] local = dto.getLocal();
        if ( local != null ) {
            dispositivo.setLocal( Arrays.copyOf( local, local.length ) );
        }
        if ( dto.getStatus() != null ) {
            dispositivo.setStatus( Enum.valueOf( DispositivoStatus.class, dto.getStatus() ) );
        }
        if ( dto.getTipo() != null ) {
            dispositivo.setTipo( Enum.valueOf( DispositivoTipos.class, dto.getTipo() ) );
        }

        return dispositivo;
    }

    @Override
    public DispositivoResponseDTO toResponseDTO(Dispositivo dispositivo) {
        if ( dispositivo == null ) {
            return null;
        }

        DispositivoResponseDTO dispositivoResponseDTO = new DispositivoResponseDTO();

        dispositivoResponseDTO.setIdDispositivo( dispositivo.getIdDispositivo() );
        Double[] local = dispositivo.getLocal();
        if ( local != null ) {
            dispositivoResponseDTO.setLocal( Arrays.copyOf( local, local.length ) );
        }
        if ( dispositivo.getStatus() != null ) {
            dispositivoResponseDTO.setStatus( dispositivo.getStatus().name() );
        }
        if ( dispositivo.getTipo() != null ) {
            dispositivoResponseDTO.setTipo( dispositivo.getTipo().name() );
        }

        return dispositivoResponseDTO;
    }

    @Override
    public List<DispositivoResponseDTO> toResponseDTOList(List<Dispositivo> dispositivo) {
        if ( dispositivo == null ) {
            return null;
        }

        List<DispositivoResponseDTO> list = new ArrayList<DispositivoResponseDTO>( dispositivo.size() );
        for ( Dispositivo dispositivo1 : dispositivo ) {
            list.add( toResponseDTO( dispositivo1 ) );
        }

        return list;
    }
}
