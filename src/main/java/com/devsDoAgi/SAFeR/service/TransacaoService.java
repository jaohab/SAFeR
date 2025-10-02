package com.devsDoAgi.SAFeR.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsDoAgi.SAFeR.repository.ContaRepository;
import com.devsDoAgi.SAFeR.repository.TransacaoRepository;

import jakarta.transaction.Transactional;

import com.devsDoAgi.SAFeR.dto.TransacaoRequestDTO;
import com.devsDoAgi.SAFeR.dto.TransacaoResponseDTO;
import com.devsDoAgi.SAFeR.mapper.TransacaoMapper;
import com.devsDoAgi.SAFeR.model.Conta;
import com.devsDoAgi.SAFeR.model.Transacao;

@Service
public class TransacaoService {
    
    private final TransacaoRepository transacaoRepository;
    private final ContaRepository contaRepository;
    private final TransacaoMapper transacaoMapper;

    public TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository,
            TransacaoMapper transacaoMapper) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
        this.transacaoMapper = transacaoMapper;
    }

    @Transactional
    public TransacaoResponseDTO criarTransacao(TransacaoRequestDTO dto) {
        Transacao transacao = transacaoMapper.toEntity(dto);
        Transacao salva = transacaoRepository.save(transacao);
        return transacaoMapper.toResponseDTO(salva);
    }

    @Transactional
    public TransacaoResponseDTO buscarPorId(Long id) { 
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    return transacaoMapper.toResponseDTO(transacao);
    }

    @Transactional
    public List<TransacaoResponseDTO> listarTransacoes() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacaoMapper.toResponseDTOList(transacoes);
    }

    @Transactional
    public TransacaoResponseDTO adicionarHistorico(Long id) {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
        Conta conta = contaRepository.findById(transacao.getNumContaOrigem())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        if (conta != null) {
            conta.addTransacao(transacao);
            contaRepository.save(conta);
        }
        return transacaoMapper.toResponseDTO(transacao);
    }

    @Transactional
    public TransacaoResponseDTO atualizarTransacao(Long id) {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));
        transacao.setTransacaoAnalisada(true);
        Transacao atualizada = transacaoRepository.save(transacao);
        return transacaoMapper.toResponseDTO(atualizada);
    }
}
