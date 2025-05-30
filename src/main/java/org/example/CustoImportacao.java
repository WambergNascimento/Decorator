package org.example;


public class CustoImportacao implements Custo {

    public float valor;

    public CustoImportacao() {
    }

    public CustoImportacao(float valor) {
        this.valor = valor;
    }

    @Override
    public float getValor() {
        return valor;
    }

    public String getEstrutura() {
        return "Importacao";
    }

}

