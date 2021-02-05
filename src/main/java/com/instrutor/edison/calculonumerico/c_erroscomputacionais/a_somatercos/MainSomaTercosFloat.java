package com.instrutor.edison.calculonumerico.c_erroscomputacionais.a_somatercos;

public class MainSomaTercosFloat {

    public static void main(String[] args) {

        float soma = 0.0F;
        float value = 1.0F / 3.0F;
        boolean exibeIntermediarios = false;

        Long tempoInicial = System.currentTimeMillis();
        Long tempoFinal ;
        Long maxContagem = 300_000L ;
        double diff = 0.0F;

        for (int i = 1; i <= maxContagem; i++) {
            soma += value;
            diff = Math.abs(soma- i * value);
            if (exibeIntermediarios)
                System.out.printf("(FLOAT)Resultado da Soma %d - Soma = %28.26f - Mult = %28.26f - Diff = %28.26f\n", i , soma , i * value, diff);
        }

        tempoFinal = System.currentTimeMillis();

        System.out.println("(FLOAT)Tempo Gasto = " + (tempoFinal-tempoInicial) + " ms - Tempo gasto por iteração = " + ((double)(tempoFinal-tempoInicial))/((double)maxContagem) + " - Diferenca = " + diff);

        // Float - Precisão de 7 Casas decimais.

    }
}
