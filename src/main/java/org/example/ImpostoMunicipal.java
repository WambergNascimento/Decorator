package org.example;

public class ImpostoMunicipal extends CustoDecorator {


    public ImpostoMunicipal(Custo custo) {
        super(custo);
    }

    @Override
    public String getNomeEstrutura() {
        return "Imposto Municipal";
    }

    @Override
    public float getPercentualValor() {
        return 2.0f;
    }
}
