package test;

import framework.core.BaseTest;
import framework.core.DSL;
import framework.core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteAlert extends BaseTest {
    private DSL dsl;

    @Before
    public void inicializaDriver(){
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL();
    }

    @Test
    public void testeVerificarAlert() {
        dsl.clicar("alert");
        Assert.assertEquals("Alert Simples", dsl.interagirAlertObterTextoConfirm());
    }

    @Test
    public void testeVerificarAlertConfirm() {
        dsl.clicar("confirm");
        Assert.assertEquals("Confirm Simples", dsl.interagirAlertObterTextoConfirm());
        Assert.assertEquals("Confirmado", dsl.interagirAlertObterTextoConfirm());
    }

    @Test
    public void testeVerificarAlertCancel() {
        dsl.clicar("confirm");
        Assert.assertEquals("Confirm Simples", dsl.interagirAlertObterTextoCancel());
        Assert.assertEquals("Negado", dsl.interagirAlertObterTextoConfirm());
    }

    @Test
    public void testeVerificarAlertPrompt() {
        dsl.clicar("prompt");
        Assert.assertEquals("Digite um numero", dsl.interagirAlertObterTexto());
        dsl.interagirAlertEscrever("54321");
        Assert.assertEquals("Era 54321?", dsl.interagirAlertObterTextoConfirm());
        Assert.assertEquals(":D", dsl.interagirAlertObterTextoConfirm());
    }
}
