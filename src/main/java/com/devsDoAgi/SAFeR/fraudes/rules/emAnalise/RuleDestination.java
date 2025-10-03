package com.devsDoAgi.SAFeR.fraudes.rules.emAnalise;

/**
 * Classe de regra -> APENAS TESTE
 * Implementa FraudRule
 *
 * @author  João Henrique
 * @version 0.1
 */

import java.util.Set;

import com.devsDoAgi.SAFeR.fraudes.engine.FraudResult;
import com.devsDoAgi.SAFeR.fraudes.interfaces.FraudRule;
import com.devsDoAgi.SAFeR.model.Transacao;

public class RuleDestination implements FraudRule {

    //private final Set<String> blacklistedAccounts = Set.of("ACC123", "ACC999");

    private String ruleName = "Destino Suspeito";

    /**
     * Override evaluate -> (Nome da Regra)
     * Método que vai receber os critérios de avaliação da regra.
     *
     * @param Transacao -> Consome um objeto Transacao.
     * @return FraudResult -> Retorna um objeto FraudResult.
     */

    @Override
    public FraudResult evaluate(Transacao transacao) {
        /*
        if (blacklistedAccounts.contains(transacao.getDestinationAccount())) {
            return new FraudResult(ruleName, 10);
        }
        */
        return new FraudResult(ruleName, 0);
    }
}
