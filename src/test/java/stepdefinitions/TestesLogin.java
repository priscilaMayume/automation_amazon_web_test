package stepdefinitions;

import Constantes.Constantes;
import Dsl.Dsl;
import Pages.AmazonBuscadorPage;
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

    @Quando("^clicar na pagina do login$")
    public void clicar_na_pagina_do_login() {
        page.setAccountClick();

    }

    @Entao("^deve esperar o elemente de email$")
    public void deveEsperarOElementeDeEmail() {
        dsl.esperarELementoById(Constantes.NUMERO_2, Constantes.ELEMENT_AP_EMAIL);

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

    @Entao("^deve fechar o navegador$")
    public void deveFecharONavegador() {
        dsl.fecharNavegador();

    }

}
