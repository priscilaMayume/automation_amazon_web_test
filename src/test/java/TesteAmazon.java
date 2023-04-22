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

    @Before
    public void abrirPagina() {
        // Local onde o Selenium abre o drive do firefox
        System.setProperty("webdriver.chrome.driver", "src/test/resources/navegador/chromedriver");
        driver = new ChromeDriver();
        // Abrir uma janela do drive
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Insirir no navegador a instrução para ir no site da Amazon
        driver.get(constantes.URL_AMAZON);
        dsl = new Dsl(driver);
    }

    //Depois que o teste encerar
    @After
    public void fecharNavegador() {
        // Fechar a conexão com o navegador
        dsl.fecharNavegador();

    }

    @Test
    public void abrirBrowserComSucesso() {
        // Checar se abriu corretamente o site da Amazon atraves do title
        Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", driver.getTitle());

    }

    @Test
    public void clicarMaisVendidosMenu() {
        // Clicar no menu
        dsl.click("nav-hamburger-menu");
        //Esperar e clicar
        dsl.esperarEClicar(5, "Mais Vendidos");

    }

    @Test
    public void deveVerificarValoresDropdownPesquisa() {
        //identificar o campo do combo
        WebElement element = dsl.buscarElementoById("searchDropdownBox");
//        //selecionar um elemento do combo
        Select box = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = box.getOptions();

        //Se uma determinada opção está presente no combo
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals(Constantes.CAMPO_GAMES)) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

    }

    @Test
    public void devePesquisarComBarraDePesquisa() {
//        // Tempo limite de carregamento da página
        dsl.tempoCarrementoPagina(4);
        // Esperar implicitamente
        dsl.esperarPaginaAbrir(3);

        //Aguardar 2 segundos para aguardar elemento visivel ou lançar a exceção
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, 6);
            driverWait.until(ExpectedConditions.visibilityOf(
                    dsl.buscarElementoByXpath("//*[@id=\"twotabsearchtextbox\"]")));
        } catch (Exception e) {
            Assert.fail(constantes.ERROR_TIME_OUT_ELEMENT);
        }
        // Escrever 1984 no buscador e clicar para pesquisar
        dsl.escreverByXpath("//*[@id=\"twotabsearchtextbox\"]", "1984");
        dsl.click("nav-search-submit-button");
        //Verificar se a tela de pesquisa foi aberta
        Assert.assertTrue(dsl.checarElementoByName("sg-col-inner","resultados para"));

    }
}
