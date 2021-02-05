package com.instrutor.edison.calculonumerico.c_erroscomputacionais.a_somatercos;

public class MainSomaTercosDouble {

    public static void main(String[] args) {

        double soma = 0.0;
        double value = 1.0 / 3.0;
        boolean mostraIntermediario = false;

        Long tempoInicial = System.currentTimeMillis();
        Long tempoFinal;
        Long maxContagem = 300_000L;
        double diff = 0.0D;

        for (int i = 1; i <= maxContagem; i++) {
            soma += value;
            diff = Math.abs(soma - i * value);
            if (mostraIntermediario)
                System.out.printf("(DOUBLE)Resultado da Soma %d - Soma = %28.26f - Mult = %28.26f - Diff = %28.26f\n", i, soma, i * value, diff);
        }

        tempoFinal = System.currentTimeMillis();
        System.out.println("(DOUBLE)Tempo Gasto = " + (tempoFinal - tempoInicial) + " ms - Tempo gasto por iteração = " + ((double) (tempoFinal - tempoInicial)) / ((double) maxContagem) + " - Diferenca = " + diff);

        // Double - Precisão de 16 casas.

    }
}
