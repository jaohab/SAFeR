package com.devsDoAgi.SAFeR.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// Responsável por retornar informações completas.
public class TransacaoResponseDTO {
    private Long idTransacao;
    private BigDecimal valor;
    private LocalDateTime dataHoraOperacao;
    private String dispositivo;
    private Double[] local;
    private String meioPagamento;
    private String numContaOrigem;
    private String numAgenciaOrigem;
    private String ispbOrigem;
    private String cpfOrigem;
    private String numContaDestino;
    private String numAgenciaDestino;
    private String ispbDestino;
    private String cpfCnpjDestino;
    private int scoreTransacao;
    private boolean transacaoAnalisada;
}
