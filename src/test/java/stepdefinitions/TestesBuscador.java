package stepdefinitions;

import Constantes.Constantes;
import Dsl.Dsl;
import Pages.AmazonBuscadorPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestesBuscador {

    private WebDriver driver;
    private Dsl dsl;
    public Constantes constantes;
    public AmazonBuscadorPage page;

    Boolean encontrou;

    @Dado("^que abrir browser com sucesso$")
    public void queAbrirBrowserComSucesso() {
        System.setProperty("webdriver.chrome.driver", constantes.PATH_CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(constantes.URL_AMAZON);
        dsl = new Dsl(driver);
        page = new AmazonBuscadorPage(driver);
    }

    @Entao("^deve esta visivel title aws$")
    public void deveEstaVisivelTitleAws() {
        Assert.assertEquals(constantes.TITLE_AMAZON, driver.getTitle());

    }

    @Entao("^deve clicar no menu dos mais vendidos$")
    public void deveClicarNoMenuDosMaisVendidos() {
        page.setNavMenuHamburguerPrincipalClick();
        dsl.esperarEClicar(constantes.NUMERO_5, constantes.CAMPO_MAIS_VENDIDOS);

    }

    @Entao("^que verifique valores no dropdown pesquisa$")
    public void queVerifiqueValoresNoDropdownPesquisa() {
        //identificar o campo do combo
        WebElement element = page.setBuscarDropdownBox();
        //selecionar um elemento do combo
        Select box = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = box.getOptions();

        //Se uma determinada opção está presente no combo
        encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals(constantes.CAMPO_GAMES)) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }

    @Entao("^encontrar com sucesso a opcao de games$")
    public void encontrarComSucessoAOpcaoDeGames() {
        Assert.assertTrue(encontrou);
    }

    @E("^deve pesquisar com barra de pesquisa$")
    public void devePesquisarComBarraDePesquisa() {
        dsl.tempoCarrementoPagina(constantes.NUMERO_4);
        dsl.esperarPaginaAbrir(constantes.NUMERO_3);

        //Aguardar 2 segundos para aguardar elemento visivel ou lançar a exceção
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, constantes.NUMERO_2);
            driverWait.until(ExpectedConditions.visibilityOf(
                    page.setBuscarTextoBuscador()));
        } catch (Exception e) {
            Assert.fail(constantes.ERROR_TIME_OUT_ELEMENT);
        }

        page.setEscreverTextoBuscador();
        page.setClicarParaBuscarTexto();
    }

    @E("^encontrar com sucesso o resultado da pesquisa$")
    public void encontrarComSucessoOResultadoDaPesquisa() {
        Assert.assertTrue(page.setBuscarResultados());

    }

    @E("^deve fechar o browser$")
    public void deveFecharOBrowser() {
        dsl.fecharNavegador();
    }

}
