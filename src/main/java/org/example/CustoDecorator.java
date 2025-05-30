package org.example;

public abstract class CustoDecorator implements Custo{
    private Custo custo;
    public String estrutura;

    public CustoDecorator(Custo custo) {
        this.custo = custo;
    }

    public Custo getCusto() {
        return custo;
    }

    public String getEstrutura() {
        return this.custo.getEstrutura() + "/" + this.getNomeEstrutura();
    }

    public abstract String getNomeEstrutura();

    public void setEstrutura(String estrutura) {
        this.estrutura = estrutura;
    }

    public void setCusto(Custo custo) {
        this.custo = custo;
    }

    public abstract float getPercentualValor();

    public float getValor() {
        return this.custo.getValor() * (1 + (this.getPercentualValor() / 100));
    }


}
