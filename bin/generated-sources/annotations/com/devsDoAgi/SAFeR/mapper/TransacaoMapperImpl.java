package com.devsDoAgi.SAFeR.mapper;

import com.devsDoAgi.SAFeR.dto.TransacaoRequestDTO;
import com.devsDoAgi.SAFeR.dto.TransacaoResponseDTO;
import com.devsDoAgi.SAFeR.enums.DispositivoTipos;
import com.devsDoAgi.SAFeR.enums.TransacaoMeioPagamento;
import com.devsDoAgi.SAFeR.model.Transacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T09:33:47-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251001-1143, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class TransacaoMapperImpl implements TransacaoMapper {

    @Override
    public Transacao toEntity(TransacaoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Transacao transacao = new Transacao();

        transacao.setCpfCnpjDestino( dto.getCpfCnpjDestino() );
        transacao.setCpfOrigem( dto.getCpfOrigem() );
        transacao.setDataHoraOperacao( dto.getDataHoraOperacao() );
        if ( dto.getDispositivo() != null ) {
            transacao.setDispositivo( Enum.valueOf( DispositivoTipos.class, dto.getDispositivo() ) );
        }
        transacao.setIspbDestino( dto.getIspbDestino() );
        transacao.setIspbOrigem( dto.getIspbOrigem() );
        Double[] local = dto.getLocal();
        if ( local != null ) {
            transacao.setLocal( Arrays.copyOf( local, local.length ) );
        }
        if ( dto.getMeioPagamento() != null ) {
            transacao.setMeioPagamento( Enum.valueOf( TransacaoMeioPagamento.class, dto.getMeioPagamento() ) );
        }
        transacao.setNumAgenciaDestino( dto.getNumAgenciaDestino() );
        transacao.setNumAgenciaOrigem( dto.getNumAgenciaOrigem() );
        transacao.setNumContaDestino( dto.getNumContaDestino() );
        transacao.setNumContaOrigem( dto.getNumContaOrigem() );
        transacao.setScoreTransacao( dto.getScoreTransacao() );
        transacao.setTransacaoAnalisada( dto.isTransacaoAnalisada() );
        transacao.setValor( dto.getValor() );

        return transacao;
    }

    @Override
    public TransacaoResponseDTO toResponseDTO(Transacao transacao) {
        if ( transacao == null ) {
            return null;
        }

        TransacaoResponseDTO transacaoResponseDTO = new TransacaoResponseDTO();

        transacaoResponseDTO.setCpfCnpjDestino( transacao.getCpfCnpjDestino() );
        transacaoResponseDTO.setCpfOrigem( transacao.getCpfOrigem() );
        transacaoResponseDTO.setDataHoraOperacao( transacao.getDataHoraOperacao() );
        if ( transacao.getDispositivo() != null ) {
            transacaoResponseDTO.setDispositivo( transacao.getDispositivo().name() );
        }
        transacaoResponseDTO.setIdTransacao( transacao.getIdTransacao() );
        transacaoResponseDTO.setIspbDestino( transacao.getIspbDestino() );
        transacaoResponseDTO.setIspbOrigem( transacao.getIspbOrigem() );
        Double[] local = transacao.getLocal();
        if ( local != null ) {
            transacaoResponseDTO.setLocal( Arrays.copyOf( local, local.length ) );
        }
        if ( transacao.getMeioPagamento() != null ) {
            transacaoResponseDTO.setMeioPagamento( transacao.getMeioPagamento().name() );
        }
        transacaoResponseDTO.setNumAgenciaDestino( transacao.getNumAgenciaDestino() );
        transacaoResponseDTO.setNumAgenciaOrigem( transacao.getNumAgenciaOrigem() );
        transacaoResponseDTO.setNumContaDestino( transacao.getNumContaDestino() );
        transacaoResponseDTO.setNumContaOrigem( transacao.getNumContaOrigem() );
        transacaoResponseDTO.setScoreTransacao( transacao.getScoreTransacao() );
        transacaoResponseDTO.setTransacaoAnalisada( transacao.isTransacaoAnalisada() );
        transacaoResponseDTO.setValor( transacao.getValor() );

        return transacaoResponseDTO;
    }

    @Override
    public List<TransacaoResponseDTO> toResponseDTOList(List<Transacao> transacao) {
        if ( transacao == null ) {
            return null;
        }

        List<TransacaoResponseDTO> list = new ArrayList<TransacaoResponseDTO>( transacao.size() );
        for ( Transacao transacao1 : transacao ) {
            list.add( toResponseDTO( transacao1 ) );
        }

        return list;
    }
}
