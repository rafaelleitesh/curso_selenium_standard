package test;

import framework.core.BaseTest;
import framework.core.DSL;
import framework.core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class TesteCampoTreinamento extends BaseTest {

    private DSL dsl;

    @Before
    public void inicializaDriver(){
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @Test
    public void testeTextField(){
        dsl.escrever("elementosForm:nome", "Teste de escrita");
        Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void testeInteragirTextField(){
        dsl.escrever("elementosForm:sugestoes", "aaaaaaaaaa bbbbbbbbbb cccccccccc dddddddddd eeeeeeeeee");
        Assert.assertEquals("aaaaaaaaaa bbbbbbbbbb cccccccccc dddddddddd eeeeeeeeee", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void testeInteragirRadioButton() {
        dsl.clicar("elementosForm:comidaFavorita:2");
        Assert.assertEquals(true, dsl.checkRadio("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void testeInteragirCombo() {
        dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void testeVerificarValoresCombo() {
        Assert.assertEquals(8, dsl.obterListaComboQuantidade("elementosForm:escolaridade"));
        Assert.assertTrue(dsl.verificarOpcoesCombo("elementosForm:escolaridade", "Mestrado"));
    }

    @Test
    public void testeVerificarValoresComboSelecionado() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

        dsl.obterOpcoesSelecionadasCombo("elementosForm:esportes");
        Assert.assertEquals(3, dsl.obterOpcoesSelecionadasCombo("elementosForm:esportes").size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");

        dsl.obterOpcoesSelecionadasCombo("elementosForm:esportes");
        Assert.assertEquals(2, dsl.obterOpcoesSelecionadasCombo("elementosForm:esportes").size());

        Assert.assertTrue(dsl.obterOpcoesSelecionadasCombo("elementosForm:esportes").containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }

    @Test
    public void testeInteragirBotoes() {
        dsl.clicar("buttonSimple");
        WebElement botao = DriverFactory.getDriver().findElement(By.id("buttonSimple"));
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    public void testeInteragirLinks() {
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.obterValorTexto(By.id("resultado")));
    }

    @Test
    public void testeBuscarTextoNaPagina() {
        Assert.assertEquals("Campo de Treinamento", dsl.obterValorTexto(By.tagName("h3")));
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterValorTexto(By.className("facilAchar")));
    }

}
