package com.devsDoAgi.SAFeR.mapper;

import com.devsDoAgi.SAFeR.dto.ClienteRequestDTO;
import com.devsDoAgi.SAFeR.dto.ClienteResponseDTO;
import com.devsDoAgi.SAFeR.model.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T09:33:47-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setAtivo( dto.isAtivo() );
        cliente.setCpf( dto.getCpf() );
        if ( dto.getDataNascimento() != null ) {
            cliente.setDataNascimento( LocalDate.parse( dto.getDataNascimento() ) );
        }
        cliente.setNome( dto.getNome() );
        cliente.setScore( dto.getScore() );

        return cliente;
    }

    @Override
    public ClienteResponseDTO toResponseDTO(Cliente conta) {
        if ( conta == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setAtivo( conta.isAtivo() );
        clienteResponseDTO.setCpf( conta.getCpf() );
        if ( conta.getDataNascimento() != null ) {
            clienteResponseDTO.setDataNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( conta.getDataNascimento() ) );
        }
        clienteResponseDTO.setNome( conta.getNome() );
        clienteResponseDTO.setScore( conta.getScore() );

        return clienteResponseDTO;
    }

    @Override
    public List<ClienteResponseDTO> toResponseDTOList(List<Cliente> contas) {
        if ( contas == null ) {
            return null;
        }

        List<ClienteResponseDTO> list = new ArrayList<ClienteResponseDTO>( contas.size() );
        for ( Cliente cliente : contas ) {
            list.add( toResponseDTO( cliente ) );
        }

        return list;
    }
}
