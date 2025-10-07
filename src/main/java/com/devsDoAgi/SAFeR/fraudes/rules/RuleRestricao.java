package com.devsDoAgi.SAFeR.fraudes.rules;

import com.devsDoAgi.SAFeR.enums.RestricaoStatus;
import com.devsDoAgi.SAFeR.fraudes.engine.FraudResult;
import com.devsDoAgi.SAFeR.fraudes.interfaces.FraudRule;
import com.devsDoAgi.SAFeR.model.Restricao;
import com.devsDoAgi.SAFeR.model.Transacao;
import com.devsDoAgi.SAFeR.service.RestricaoService;

/**
 * Classe de regra
 * Implementa FraudRule
 *
 * @author  João Henrique
 * @version 1.0
 */

public class RuleRestricao implements FraudRule {

    private String ruleName = "Regra de Análise de Restrição em CPF/CNPJ de Destino";

    /**
     * Override evaluate -> RuleRestricao
     * Método que vai receber os critérios de avaliação da regra.
     *
     * @param Transacao -> Consome um objeto Transacao.
     * @return FraudResult -> Retorna um objeto FraudResult.
     */

    @Override
    public FraudResult evaluate(Transacao transacao) {

        String cpfDestino = transacao.getCpfCnpjDestino();
        Restricao retricao = RestricaoService.findByCpf(cpfDestino);
        
        if (retricao != null) {
            if (retricao.getStatus().equals(RestricaoStatus.CANCELADO)) {
                return new FraudResult(ruleName, 60);
            } else if (retricao.getStatus().equals(RestricaoStatus.BLOQUEADO)) {
                return new FraudResult(ruleName, 60);
            } else if (retricao.getStatus().equals(RestricaoStatus.COM_RESTRICAO)) {
                return new FraudResult(ruleName, 10);
            } else if (retricao.getStatus().equals(RestricaoStatus.SEM_RESTRICAO)) {
                return new FraudResult(ruleName, 0);
            }
        }
        
        return new FraudResult(ruleName, 0);
    }
}

