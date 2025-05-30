package org.example;

public class ImpostoFederal extends CustoDecorator {
    public ImpostoFederal(Custo custo) {
        super(custo);
    }

    @Override
    public String getNomeEstrutura() {
        return "Imposto Federal";
    }

    @Override
    public float getPercentualValor() {
        return 10.0f;
    }
}
