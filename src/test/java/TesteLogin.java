import Constantes.Constantes;
import Dsl.Dsl;
import Pages.AmazonLoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {

    private WebDriver driver;
    public AmazonLoginPage page;
    private Dsl dsl;

    @Before
    public void abrirPagina() {
        System.setProperty("webdriver.chrome.driver", Constantes.PATH_CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(Constantes.URL_AMAZON);
        dsl = new Dsl(driver);
        page = new AmazonLoginPage(driver);
    }

    @After
    public void fecharNavegador() {
        dsl.fecharNavegador();

    }

    @Test
    public void deveFazerLoginComSucesso() {
        page.setAccountClick();

        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_EMAIL);
        page.setEscreverLogin();
        page.setClickContinuar();

        dsl.esperarELementoById(Constantes.NUMERO_3, Constantes.ELEMENT_AP_PSW);
        page.setEscreverPswValido();
        page.setSignInSubmitClick();
        dsl.esperarELementoTagName(Constantes.NUMERO_3, Constantes.SAUDACAO_JOSE);
        Assert.assertTrue(page.setCheckSaudacao());

    }

    @Test
    public void deveFazerLoginEmailErrado() {
        page.setAccountClick();

        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_EMAIL);
        page.setEscreverLoginInvalido();
        page.setClickContinuar();
        dsl.esperarELementoXPath(Constantes.NUMERO_2, Constantes.ELEMENT_ERRO_MSG_EMAIL);
        Assert.assertTrue(page.setCheckErroEmailInvalido());

    }

    @Test
    public void deveFazerLoginComSenhaErrada() {
        page.setAccountClick();

        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_EMAIL);
        page.setEscreverLogin();
        page.setClickContinuar();

        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_PSW);
        page.setEscreverPswInvalido();
        page.setSignInSubmitClick();

        Assert.assertTrue(page.setCheckErroPswInvalido());

    }
}
