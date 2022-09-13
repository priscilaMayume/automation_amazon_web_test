import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TesteAmazon {

    @Test
    public void abrirBrowserComSucesso() {
        // Local onde o Selenium abre o drive do firefox
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        // Abrir uma janela do drive
        driver.manage().window().maximize();
        // Insirir no navegador a instrução para ir no site da Amazon
        driver.get("https://www.amazon.com.br/");
        // Checar se abriu corretamente o site da Amazon atraves do title
        Assert.assertEquals("Amazon.com.br | Tudo pra você, de A a Z.", driver.getTitle());
        // Fechar a conexão com o navegador
        driver.quit();
    }

    @Test
    public void clicarMaisVendidosMenu() {
        // Local onde o Selenium abre o drive do firefox
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        // Abrir uma janela do drive
        driver.manage().window().maximize();
        // Insirir no navegador a instrução para ir no site da Amazon
        driver.get("https://www.amazon.com.br/");

        driver.findElement(By.id("nav-hamburger-menu")).click();

        //Esperar e clicar
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mais Vendidos")));

        driver.quit();

    }

    @Test
    public void deveVerificarValoresDropdownPesquisa() {
        // Local onde o Selenium abre o drive do firefox
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver");
        // Abrir uma janela do drive
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // Insirir no navegador a instrução para ir no site da Amazon
        driver.get("https://www.amazon.com.br/");

        //identificar o campo do combo
        WebElement element = driver.findElement(By.id("searchDropdownBox"));
        //selecionar um elemento do combo
        Select box = new Select(element);
        //retorna uma lista de WebElements
        List<WebElement> options = box.getOptions();

        //Se uma determinada opção está presente no combo
        boolean encontrou = false;
        for (WebElement option : options) {
            if (option.getText().equals("Games")) {
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);

        driver.quit();

    }

    @Test
    public void devePesquisarComBarraDePesquisa() {
        // Local onde o Selenium abre o drive do firefox
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        // Abrir uma janela do drive
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Tempo limite de carregamento da página
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        // Esperar implicitamente
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Insirir no navegador a instrução para ir no site da Amazon
        driver.get("https://www.amazon.com.br/");
        //Aguardar 2 segundos para aguardar elemento visivel ou lançar a exceção
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, 6);
            driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"))));
        } catch (Exception e) {
            Assert.fail("Tempo excedido para aguardar elemento");
        }
        // Escrever 1984 no buscador e clicar para pesquisar
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("1984");
        driver.findElement(By.id("nav-search-submit-button")).click();

        //Verificar se a tela de pesquisa foi aberta
        Assert.assertTrue(driver.findElement(By.className("sg-col-inner")).getText().contains("resultados para"));

        // Fecho a conexão com o navegador
        driver.quit();

    }
}
