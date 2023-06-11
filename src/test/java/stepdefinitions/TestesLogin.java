package stepdefinitions;

import Constantes.Constantes;
import Dsl.Dsl;
import Pages.AmazonLoginPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestesLogin {

    private WebDriver driver;
    private Dsl dsl;
    public Constantes constantes;
    public AmazonLoginPage page;

    public WebDriver acessarWeb() {
        System.setProperty("webdriver.chrome.driver", constantes.PATH_CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(constantes.URL_AMAZON);
        dsl = new Dsl(driver);
        page = new AmazonLoginPage(driver);

        return driver;
    }

    @Dado("^que abrir navegador com sucesso$")
    public void queAbrirNavegadorComSucesso() {
        driver = acessarWeb();

    }

    @Quando("^esperar a abertura da Pg principal$")
    public void esperarAAberturaDaPgPrincipal() {
        dsl.esperarCarregarPaginaPrincipal();
    }

    @Entao("^deve esperar o elemento de title$")
    public void deveEsperarOElementoDeTitle() {
        dsl.verificarTitle();
    }

    @E("^deve esperar o elemento de msg de psw errado$")
    public void deveEsperarOElementoDeMsgDePswErrado() {
        dsl.esperarELementoById(Constantes.NUMERO_4, Constantes.ELEMENT_ERRO_PSW);

    }

    @E("^deve verificar erro na msg de psw errado$")
    public void deveVerificarErroNaMsgDePswErrado() {
        page.setCheckErroPswInvalido();
    }


    @E("^clicar na pagina do login$")
    public void clicarNaPaginaDoLogin() {
        dsl.esperarELementoById(Constantes.NUMERO_3, Constantes.ELEMENT_ACCOUNT_LIST);
        page.setAccountMover();
        page.setAccountClick();

    }

    @E("^deve esperar o elemento de email$")
    public void deveEsperarOElementoDeEmail() {
        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_EMAIL);

    }

    @E("^deve escrever login invalido$")
    public void deveEscreverLoginInvalido() {
        page.setEscreverLoginInvalido();
    }

    @E("^deve escrever login valido$")
    public void deveEscreverLoginValido() {
        page.setEscreverLogin();
    }

    @E("^deve clicar em continuar$")
    public void deveClicarEmContinuar() {
        page.setClickContinuar();
    }

    @E("^deve esperar elemento de PSW$")
    public void deveEsperarElementoDePSW() {
        dsl.esperarELementoById(Constantes.NUMERO_3, Constantes.ELEMENT_AP_PSW);
    }

    @E("^deve escrever psw valida$")
    public void deveEscreverPswValida() {
        page.setEscreverPswValido();
    }

    @E("^deve escrever psw invalida$")
    public void deveEscreverPswInvalida() {
        page.setEscreverPswInvalido();
    }


    @E("^deve clicar em submeter$")
    public void deveClicarEmSubmeter() {
        page.setSignInSubmitClick();

    }


    @E("^deve esperar elemento de saudacao personalizada$")
    public void deveEsperarElementoDeSaudacaoPersonalizada() {
        try {
            dsl.esperarELementoTagName(Constantes.NUMERO_3, Constantes.SAUDACAO_JOSE);
        } catch (Exception e) {
            dsl.fecharNavegador();
            Assert.fail(constantes.ERROR_LOGIN_SEGURANCA);

        }
    }

    @E("^deve verificar a saudacao personalizada$")
    public void deveVerificarASaudacaoPersonalizada() {
        try {
            Assert.assertTrue(page.setCheckSaudacao());
        } catch (Exception e) {
            dsl.fecharNavegador();
            Assert.fail(constantes.ERROR_LOGIN_SEGURANCA);

        }
    }

    @E("^deve mover ponteiro para o menu conta$")
    public void deveMoverPonteiroParaOMenuConta() {
        try {
            page.setAccountMover();
        } catch (Exception e) {
            dsl.fecharNavegador();
            Assert.fail(constantes.ERROR_LOGIN_SEGURANCA);

        }
    }

    @E("^deve fazer logout$")
    public void deveFazerLogout() {
        try {
            page.setClickSair();
        } catch (Exception e) {
            dsl.fecharNavegador();
            Assert.fail(constantes.ERROR_LOGIN_SEGURANCA);

        }
    }

    @E("^deve esperar o elemento de msg de email errado$")
    public void deveEsperarOElementoDeMsgDeEmailErrado() {
        dsl.esperarELementoXPath(Constantes.NUMERO_2, Constantes.ELEMENT_ERRO_MSG_EMAIL);
    }


    @E("^deve verificar erro na msg de email errada$")
    public void deveVerificarErroNaMsgDeEmailErrada() {
        Assert.assertTrue(page.setCheckErroEmailInvalido());
    }

    @E("^deve fechar o navegador$")
    public void deveFecharONavegador() {
        dsl.fecharNavegador();

    }

    @E("^deve verificar erro na msg de psw errada$")
    public void deveVerificarErroNaMsgDePswErrada() {
        Assert.assertTrue(page.setCheckErroPswInvalido());
    }

}
