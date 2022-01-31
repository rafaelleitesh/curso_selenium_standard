package page;

import framework.core.BasePage;
import framework.core.DSL;
import org.openqa.selenium.By;

public class CampoTreinamentoPage extends BasePage {

    public void setNome(String valor) {
        dsl.escrever("elementosForm:nome", valor);
    }

    public void setSobrenome(String valor) {
        dsl.escrever("elementosForm:sobrenome", valor);
    }

    public void setSexoMasculino() {
        dsl.clicar("elementosForm:sexo:0");
    }

    public void setComidaFavoritaPizza() {
        dsl.clicar("elementosForm:comidaFavorita:2");
    }

    public void setEscolaridade(String valor) {
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String valor) {
        dsl.selecionarCombo("elementosForm:esportes", valor);
    }

    public void cadastrar() {
        dsl.clicar("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obterValorTexto(By.id("resultado"));
    }

    public String obterNomeCadastro() {
        return dsl.obterValorTexto(By.id("descNome"));
    }

    public String obterSobrenomeCadastro() {
        return dsl.obterValorTexto(By.id("descSobrenome"));
    }

    public String obterSexoCadastro() {
        return dsl.obterValorTexto(By.id("descSexo"));
    }

    public String obterComidaCadastro() {
        return dsl.obterValorTexto(By.id("descComida"));
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterValorTexto(By.id("descEscolaridade"));
    }

    public String obterEsporteCadastro() {
        return dsl.obterValorTexto(By.id("descEsportes"));
    }
}
