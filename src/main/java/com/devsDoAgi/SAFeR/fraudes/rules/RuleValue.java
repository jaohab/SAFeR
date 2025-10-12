package com.devsDoAgi.SAFeR.fraudes.rules;

import com.devsDoAgi.SAFeR.fraudes.engine.FraudResult;
import com.devsDoAgi.SAFeR.fraudes.interfaces.FraudRule;
import com.devsDoAgi.SAFeR.model.Transacao;
import com.devsDoAgi.SAFeR.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@AllArgsConstructor
@Data
@Component
public class RuleValue implements FraudRule {

    @Autowired
    TransacaoRepository transacaoRepository;

    public BigDecimal calculateCeiling (Transacao transacao){ // Calculo do teto medio para alarme de acordo com histórico do cliente

        final BigDecimal BASE_CEILING = new BigDecimal(1000.00);

        List<Transacao> transacoes = transacaoRepository.findBynumContaOrigem(transacao.getNumContaOrigem()).stream()
                .filter(t -> t.getScoreTransacao() < 50)
                .toList();
        if (transacoes.size() <= 10){ return BASE_CEILING; }

        BigDecimal averageValue  = transacoes.stream()
                .map(t -> t.getValor())
                .reduce(BigDecimal.valueOf(0),(v1,v2) -> v1.add(v2))
                .divide(BigDecimal.valueOf(transacoes.size()),2, RoundingMode.HALF_UP).add(BASE_CEILING);
        return averageValue;
    }

    public BigDecimal calcToleranceOverCelling(BigDecimal ceiling){
        final BigDecimal TOLERANCE_PERCENTAGE = BigDecimal.valueOf(10);
        final BigDecimal HUNDRED = new BigDecimal("100");
        BigDecimal toleranceCeiling = ceiling.
                add(ceiling.multiply(TOLERANCE_PERCENTAGE).
                        divide(HUNDRED,2,RoundingMode.HALF_UP));
        return toleranceCeiling;
    }

    @Override
    public FraudResult evaluate(Transacao transacao){
        BigDecimal ceiling = calculateCeiling(transacao);
        BigDecimal tolerance = calcToleranceOverCelling(ceiling);
        BigDecimal transactionValue = transacao.getValor();

        //  Verifica se o valor da transação é menor ou igual ao teto de alarme

        //  a.compareTo(b) -> retornará
        //  1 -> if a > b
        //  0 -> if a == b
        // -1 -> if a < b

        if (ceiling.compareTo(transactionValue) > 0){
            return new FraudResult("Value rule", 0);
        } else if (transactionValue.compareTo(ceiling) > 0 && transactionValue.compareTo(tolerance) < 0) {
            return new FraudResult("Value rule", 7);
        } else {
            return new FraudResult("Value rule", 90); //Automaticamente confirmado como fraude
        }
    }
}