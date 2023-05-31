import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteLogin {

    private WebDriver driver;
    private Constantes constantes;
    private AmazonPage page;
    private Dsl dsl;

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
    public void deveFazerLoginComSucesso() {
        driver.findElement(By.id("nav-link-accountList")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2); // Espera de 2 segundos
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

        driver.findElement(By.id("ap_email")).sendKeys("jose.test.automation@gmail.com");
        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        driver.findElement(By.id("ap_password")).sendKeys("brasil@123");
        driver.findElement(By.id("signInSubmit")).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Olá, Jose"));
        System.out.println(driver.findElement(By.tagName("body")).getText().contains("Olá, Jose"));
        Assert.assertEquals("Olá, Jose", driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
    }

    @Test
    public void deveFazerLoginEmailErrado() {
        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("sasaksoojcvd@okdos.com");
        driver.findElement(By.id("continue")).click();
        String captura = driver.findElement(By.className("a-list-item")).getText();

        Assert.assertEquals("Não encontramos uma conta associada a este endereço de e-mail", captura);

    }

    @Test
    public void deveFazerLoginComSenhaErrada() {
        driver.findElement(By.id("nav-link-accountList")).click();

        driver.findElement(By.id("ap_email")).sendKeys("jose.test.automation@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("123456");
        driver.findElement(By.id("signInSubmit")).click();

        String captura = driver.findElement(By.className("a-list-item")).getText();

        Assert.assertEquals("Sua senha está incorreta", captura);

    }
}
