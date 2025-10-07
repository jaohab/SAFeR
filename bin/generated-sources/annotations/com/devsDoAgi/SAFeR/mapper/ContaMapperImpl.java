package com.devsDoAgi.SAFeR.mapper;

import com.devsDoAgi.SAFeR.dto.ContaRequestDTO;
import com.devsDoAgi.SAFeR.dto.ContaResponseDTO;
import com.devsDoAgi.SAFeR.dto.TransacaoRequestDTO;
import com.devsDoAgi.SAFeR.enums.ContaStatus;
import com.devsDoAgi.SAFeR.enums.DispositivoTipos;
import com.devsDoAgi.SAFeR.enums.TransacaoMeioPagamento;
import com.devsDoAgi.SAFeR.model.Conta;
import com.devsDoAgi.SAFeR.model.Transacao;
import java.math.BigDecimal;
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
public class ContaMapperImpl implements ContaMapper {

    @Override
    public Conta toEntity(ContaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Conta conta = new Conta();

        conta.setHistoricoTransacoes( transacaoRequestDTOListToTransacaoList( dto.getHistoricoTransacoes() ) );
        conta.setIspb( dto.getIspb() );
        if ( dto.getLimiteNoturno() != null ) {
            conta.setLimiteNoturno( new BigDecimal( dto.getLimiteNoturno() ) );
        }
        conta.setNumAgencia( dto.getNumAgencia() );
        conta.setNumConta( dto.getNumConta() );
        if ( dto.getStatus() != null ) {
            conta.setStatus( Enum.valueOf( ContaStatus.class, dto.getStatus() ) );
        }

        return conta;
    }

    @Override
    public ContaResponseDTO toResponseDTO(Conta conta) {
        if ( conta == null ) {
            return null;
        }

        ContaResponseDTO contaResponseDTO = new ContaResponseDTO();

        contaResponseDTO.setCliente( conta.getCliente() );
        contaResponseDTO.setDataAbertura( conta.getDataAbertura() );
        contaResponseDTO.setDispositivo( conta.getDispositivo() );
        List<Transacao> list = conta.getHistoricoTransacoes();
        if ( list != null ) {
            contaResponseDTO.setHistoricoTransacoes( new ArrayList<Transacao>( list ) );
        }
        contaResponseDTO.setIspb( conta.getIspb() );
        if ( conta.getLimiteNoturno() != null ) {
            contaResponseDTO.setLimiteNoturno( conta.getLimiteNoturno().toString() );
        }
        contaResponseDTO.setNumAgencia( conta.getNumAgencia() );
        contaResponseDTO.setNumConta( conta.getNumConta() );
        if ( conta.getStatus() != null ) {
            contaResponseDTO.setStatus( conta.getStatus().name() );
        }

        return contaResponseDTO;
    }

    @Override
    public List<ContaResponseDTO> toResponseDTOList(List<Conta> contas) {
        if ( contas == null ) {
            return null;
        }

        List<ContaResponseDTO> list = new ArrayList<ContaResponseDTO>( contas.size() );
        for ( Conta conta : contas ) {
            list.add( toResponseDTO( conta ) );
        }

        return list;
    }

    protected Transacao transacaoRequestDTOToTransacao(TransacaoRequestDTO transacaoRequestDTO) {
        if ( transacaoRequestDTO == null ) {
            return null;
        }

        Transacao transacao = new Transacao();

        transacao.setCpfCnpjDestino( transacaoRequestDTO.getCpfCnpjDestino() );
        transacao.setCpfOrigem( transacaoRequestDTO.getCpfOrigem() );
        transacao.setDataHoraOperacao( transacaoRequestDTO.getDataHoraOperacao() );
        if ( transacaoRequestDTO.getDispositivo() != null ) {
            transacao.setDispositivo( Enum.valueOf( DispositivoTipos.class, transacaoRequestDTO.getDispositivo() ) );
        }
        transacao.setIspbDestino( transacaoRequestDTO.getIspbDestino() );
        transacao.setIspbOrigem( transacaoRequestDTO.getIspbOrigem() );
        Double[] local = transacaoRequestDTO.getLocal();
        if ( local != null ) {
            transacao.setLocal( Arrays.copyOf( local, local.length ) );
        }
        if ( transacaoRequestDTO.getMeioPagamento() != null ) {
            transacao.setMeioPagamento( Enum.valueOf( TransacaoMeioPagamento.class, transacaoRequestDTO.getMeioPagamento() ) );
        }
        transacao.setNumAgenciaDestino( transacaoRequestDTO.getNumAgenciaDestino() );
        transacao.setNumAgenciaOrigem( transacaoRequestDTO.getNumAgenciaOrigem() );
        transacao.setNumContaDestino( transacaoRequestDTO.getNumContaDestino() );
        transacao.setNumContaOrigem( transacaoRequestDTO.getNumContaOrigem() );
        transacao.setScoreTransacao( transacaoRequestDTO.getScoreTransacao() );
        transacao.setTransacaoAnalisada( transacaoRequestDTO.isTransacaoAnalisada() );
        transacao.setValor( transacaoRequestDTO.getValor() );

        return transacao;
    }

    protected List<Transacao> transacaoRequestDTOListToTransacaoList(List<TransacaoRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Transacao> list1 = new ArrayList<Transacao>( list.size() );
        for ( TransacaoRequestDTO transacaoRequestDTO : list ) {
            list1.add( transacaoRequestDTOToTransacao( transacaoRequestDTO ) );
        }

        return list1;
    }
}
