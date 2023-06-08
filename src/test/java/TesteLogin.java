import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {

    private WebDriver driver;
    public AmazonPage page;
    private Dsl dsl;

    @Before
    public void abrirPagina() {
        System.setProperty("webdriver.chrome.driver", Constantes.PATH_CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(Constantes.URL_AMAZON);
        dsl = new Dsl(driver);
        page = new AmazonPage(driver);
    }

    @After
    public void fecharNavegador() {
        dsl.fecharNavegador();

    }

    @Test
    public void deveFazerLoginComSucesso() {
        driver.findElement(By.id("nav-link-accountList")).click();

        dsl.esperarELementoById(2,"ap_email");
        driver.findElement(By.id("ap_email")).sendKeys("jose.test.automation@gmail.com");
        driver.findElement(By.id("continue")).click();

        dsl.esperarELementoById(2,"ap_password");
        driver.findElement(By.id("ap_password")).sendKeys("brasil@123");
        driver.findElement(By.id("signInSubmit")).click();

        dsl.esperarELementoTagName(2,"Olá, Jose");
        System.out.println(driver.findElement(By.tagName("body")).getText().contains("Olá, Jose"));
        Assert.assertEquals("Olá, Jose", driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
    }

    @Test
    public void deveFazerLoginEmailErrado() {
        driver.findElement(By.id("nav-link-accountList")).click();

        dsl.esperarELementoById(2,"ap_email");
        driver.findElement(By.id("ap_email")).sendKeys("sasaksoojcvd@okdos.com");
        driver.findElement(By.id("continue")).click();

        dsl.esperarELementoXPath(2,"//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span");
        String captura = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")).getText();

        Assert.assertEquals("Não encontramos uma conta associada a este endereço de e-mail", captura);

    }

    @Test
    public void deveFazerLoginComSenhaErrada() {
        driver.findElement(By.id("nav-link-accountList")).click();

        dsl.esperarELementoById(2,"ap_email");
        driver.findElement(By.id("ap_email")).sendKeys("jose.test.automation@gmail.com");
        driver.findElement(By.id("continue")).click();

        dsl.esperarELementoById(2,"ap_password");
        driver.findElement(By.id("ap_password")).sendKeys("123456");
        driver.findElement(By.id("signInSubmit")).click();

        String captura = driver.findElement(By.className("a-list-item")).getText();
        Assert.assertEquals("Sua senha está incorreta", captura);

    }
}
