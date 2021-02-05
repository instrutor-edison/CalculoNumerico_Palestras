package com.instrutor.edison.calculonumerico.c_erroscomputacionais.a_somatercos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainSomaTercosBigDecimal {

    public static void main(String[] args) {

        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal um = BigDecimal.ONE;
        BigDecimal tres = BigDecimal.valueOf(3.0);

        int precisao = 20;

        MathContext mc = new MathContext(precisao, RoundingMode.CEILING);
        MathContext mcMult = new MathContext(precisao+10, RoundingMode.CEILING);

        BigDecimal umTerco = um.divide(tres, mc);

        Long tempoInicial = System.currentTimeMillis();
        Long tempoFinal ;
        Long maxContagem = 300_000L ;

        for (int i = 1; i <= maxContagem; i++) {
            soma = soma.add(umTerco, mc);
            BigDecimal mult =  umTerco.multiply(BigDecimal.valueOf(i), mcMult);
            System.out.printf("(BIGDECIMAL)Resultado da Soma %d - %s - Porduto %s - Diff %s\n", i , soma.toPlainString(), mult.toPlainString(), soma.subtract(mult).abs(mcMult).toPlainString() );
        }

        tempoFinal = System.currentTimeMillis();

        System.out.println("(BIGDECIMAL)Tempo Gasto = " + (tempoFinal-tempoInicial) + " ms - Tempo gasto por iteração = " + ((double)(tempoFinal-tempoInicial))/((double)maxContagem) );

    }
}
