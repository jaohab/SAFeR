package com.devsDoAgi.SAFeR.fraudes.rules.emAnalise;

import com.devsDoAgi.SAFeR.fraudes.engine.FraudResult;
import com.devsDoAgi.SAFeR.fraudes.interfaces.FraudRule;
import com.devsDoAgi.SAFeR.model.Transacao;

/**
 * Classe de regra -> APENAS TESTE
 * Implementa FraudRule
 *
 * @author  João Henrique
 * @version 0.1
 */

public class RuleOrigen implements FraudRule {

    private final String lastKnownLocation = "São Paulo"; // Exemplo fixo

    private String ruleName = "Geográfica";

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
        if (!transacao.getLocation().equals(lastKnownLocation)) {
            return new FraudResult(ruleName, 15);
        }
        */
        return new FraudResult(ruleName, 0);
    }
}