package com.instrutor.edison.calculonumerico.c_erroscomputacionais.a_somatercos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class MainSomaTercosBigDecimalErroETempo {

    public static void main(String[] args) {
        for ( int i = 5; i < 200; i++){
            executaSomas(i, i+10, true, false);
        }
    }

    private static int casaDecimalUsada (String str){
        char [] chars = str.toCharArray();
        int casas = 0;
        if (str.startsWith("0."))
            for (int i = 2; i < chars.length; i++){
                casas --;
                if ( chars[i] != '0' )
                    break;
            }
        else
            for ( int i = 0; i< chars.length; i++) {
                casas++;
                if (chars[i] == '.')
                    break;
            }
        return casas;
    }

    public static void executaSomas(int casasSoma, int casasMult, boolean excelMode, boolean imprimeParciais) {

        BigDecimal soma = BigDecimal.ZERO;
        BigDecimal um = BigDecimal.ONE;
        BigDecimal tres = BigDecimal.valueOf(3.0);

        MathContext mc = new MathContext(casasSoma, RoundingMode.CEILING);
        MathContext mcMult = new MathContext(casasMult, RoundingMode.CEILING);

        BigDecimal umTerco = um.divide(tres, mc);

        Long tempoInicial = System.currentTimeMillis();
        Long tempoFinal ;
        Long maxContagem = 300_000L ;
        BigDecimal diff = BigDecimal.ZERO;

        for (int i = 1; i <= maxContagem; i++) {
            soma = soma.add(umTerco, mc);
            BigDecimal mult =  umTerco.multiply(BigDecimal.valueOf(i), mcMult);
            diff = soma.subtract(mult).abs(mcMult);
            if (imprimeParciais)
                System.out.printf("(BIGDECIMAL)Resultado da Soma %d - %s - Produto %s - Diff %s\n", i , soma.toPlainString(), mult.toPlainString(), diff.toPlainString() );
        }

        tempoFinal = System.currentTimeMillis();
        if (excelMode) {
            double tempoPorIteracao = (double) (tempoFinal - tempoInicial);
            tempoPorIteracao /= ((double) maxContagem);
            tempoPorIteracao *= 1_000.0D;
            System.out.println("%d|%d|%d|%13.10f".formatted(casasSoma,casaDecimalUsada(diff.toPlainString()), tempoFinal - tempoInicial, tempoPorIteracao));
        }else {
            System.out.println("(BIGDECIMAL)Tempo Gasto = " + (tempoFinal - tempoInicial) + " ms - Tempo gasto por iteração = " + ((double) (tempoFinal - tempoInicial)) / ((double) maxContagem));
        }

    }
}
