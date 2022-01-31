package test;

import framework.core.BaseTest;
import framework.core.DSL;
import framework.core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest {

    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    public void inicializaDriver(){
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
        page = new CampoTreinamentoPage();
    }

    @Test
    public void testeRealizarCadastroSucesso() {
        page.setNome("Rafael");
        page.setSobrenome("Leite");
        page.setSexoMasculino();
        page.setComidaFavoritaPizza();
        page.setEscolaridade("Mestrado");
        page.setEsporte("Natacao");
        page.cadastrar();

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Rafael"));
        Assert.assertEquals("Sobrenome: Leite", page.obterSobrenomeCadastro());
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
    }

}
