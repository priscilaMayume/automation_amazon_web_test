import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TesteAmazon {

    private WebDriver driver;
    private Dsl dsl;
    private Constantes constantes;
    private AmazonPage page;

    @Before
    public void abrirPagina() {
        System.setProperty("webdriver.chrome.driver", constantes.PATH_CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(constantes.URL_AMAZON);
        dsl = new Dsl(driver);
        page = new AmazonPage(driver);
    }

    @After
    public void fecharNavegador() {
        dsl.fecharNavegador();

    }

    @Test
    public void abrirBrowserComSucesso() {
        Assert.assertEquals(constantes.TITLE_AMAZON, driver.getTitle());

    }

    @Test
    public void clicarMaisVendidosMenu() {
        page.setNavMenuHamburguerPrincipalClick();
        dsl.esperarEClicar(constantes.NUMERO_5, constantes.CAMPO_MAIS_VENDIDOS);

    }

    @Test
    public void deveVerificarValoresDropdownPesquisa() {
        //identificar o campo do combo
        WebElement element = page.setBuscarDropdownBox();
//        //selecionar um elemento do combo
        Select box = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = box.getOptions();

        //Se uma determinada opção está presente no combo
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals(constantes.CAMPO_GAMES)) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }

    @Test
    public void devePesquisarComBarraDePesquisa() {
        dsl.tempoCarrementoPagina(constantes.NUMERO_4);
        dsl.esperarPaginaAbrir(constantes.NUMERO_3);

        //Aguardar 2 segundos para aguardar elemento visivel ou lançar a exceção
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, constantes.NUMERO_6);
            driverWait.until(ExpectedConditions.visibilityOf(
                    page.setBuscarTextoBuscador()));
        } catch (Exception e) {
            Assert.fail(constantes.ERROR_TIME_OUT_ELEMENT);
        }

        page.setEscreverTextoBuscador();
        page.setClicarParaBuscarTexto();
        Assert.assertTrue(page.setBuscarResultados());

    }
}
