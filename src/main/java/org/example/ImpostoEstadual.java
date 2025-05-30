package org.example;

public class ImpostoEstadual extends CustoDecorator {
    public ImpostoEstadual(Custo custo) {
        super(custo);
    }

    @Override
    public String getNomeEstrutura() {
        return "Imposto Estadual";
    }

    @Override
    public float getPercentualValor() {
        return 18.0f;
    }
}
