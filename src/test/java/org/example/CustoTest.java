package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustoTest {

    @Test
    void deveRetornarValorCustoBase() {
        Custo custo = new CustoImportacao(1000.0f);
        assertEquals(1000.0f, custo.getValor());
    }

    @Test
    void deveRetornarValorCustoComImpostoFederal() {
        Custo custo = new ImpostoMunicipal(new CustoImportacao(1000.0f));
        assertEquals(1020.f, custo.getValor());
    }

    @Test
    void deveRetornarValorCustoComImpostoEstadual() {
        Custo custo = new ImpostoEstadual(new CustoImportacao(1000.0f));
        assertEquals(1180.0f, custo.getValor(), 0.01f);
    }

    @Test
    void deveRetornarValorCustoComImpostoMunicipal() {
        Custo custo = new ImpostoMunicipal(new CustoImportacao(1000.0f));
        assertEquals(1020.0f, custo.getValor());
    }

    @Test
    void deveRetornarValorCustoComImpostoFederalMaisEstadual() {
        Custo custo = new ImpostoEstadual(new ImpostoFederal(new CustoImportacao(1000.0f)));
        assertEquals(1298.0f, custo.getValor(), 0.01f);
    }

    @Test
    void deveRetornarValorCustoComImpostoFederalMaisMunicipal() {
        Custo custo = new ImpostoMunicipal(new ImpostoFederal(new CustoImportacao(1000.0f)));
        assertEquals(1122.0f, custo.getValor());
    }

    @Test
    void deveRetornarValorCustoComImpostoEstadualMaisMunicipal() {
        Custo custo = new ImpostoMunicipal(new ImpostoEstadual(new CustoImportacao(1000.0f)));
        assertEquals(1203.6f, custo.getValor(), 0.01f); // Tolerância de 0.01 para floats
    }

    @Test
    void deveRetornarValorCustoComTodosImpostos() {
        Custo custo = new ImpostoMunicipal(new ImpostoEstadual(new ImpostoFederal(new CustoImportacao(1000.0f))));
        assertEquals(1323.96f, custo.getValor(), 0.01f);
    }
    @Test
    void deveRetornarEstruturaCustoBase() {
        Custo custo = new CustoImportacao();
        assertEquals("Importacao", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoFederal() {
        Custo custo = new ImpostoFederal(new CustoImportacao());
        assertEquals("Importacao/Imposto Federal", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoEstadual() {
        Custo custo = new ImpostoEstadual(new CustoImportacao());
        assertEquals("Importacao/Imposto Estadual", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoMunicipal() {
        Custo custo = new ImpostoMunicipal(new CustoImportacao());
        assertEquals("Importacao/Imposto Municipal", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoFederalMaisEstadual() {
        Custo custo = new ImpostoEstadual(new ImpostoFederal(new CustoImportacao()));
        assertEquals("Importacao/Imposto Federal/Imposto Estadual", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoFederalMaisMunicipal() {
        Custo custo = new ImpostoMunicipal(new ImpostoFederal(new CustoImportacao()));
        assertEquals("Importacao/Imposto Federal/Imposto Municipal", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComImpostoEstadualMaisMunicipal() {
        Custo custo = new ImpostoMunicipal(new ImpostoEstadual(new CustoImportacao()));
        assertEquals("Importacao/Imposto Estadual/Imposto Municipal", custo.getEstrutura());
    }

    @Test
    void deveRetornarEstruturaCustoComTodosImpostos() {
        Custo custo = new ImpostoMunicipal(new ImpostoEstadual(new ImpostoFederal(new CustoImportacao())));
        assertEquals("Importacao/Imposto Federal/Imposto Estadual/Imposto Municipal", custo.getEstrutura());
    }
}
