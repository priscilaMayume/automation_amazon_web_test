package stepdefinitions;

import Constantes.Constantes;
import Dsl.Dsl;
import Pages.AmazonBuscadorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericStep {

    private WebDriver driver;
    private Dsl dsl;
    public Constantes constantes;
    private AmazonBuscadorPage page;
    @Given("I open the browser")
    public void openBrowser() {
        // Configurar o caminho do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/navegador/chromedriver");

        // Inicializar o WebDriver do Chrome
        driver = new ChromeDriver();
    }

    @When("I navigate to Google")
    public void navigateToGoogle() {
        // Navegar para a página do Google
        driver.get("https://www.google.com");
    }

    @Then("Google homepage is displayed")
    public void verifyHomePage() {
        // Verificar se a página do Google foi carregada
        String pageTitle = driver.getTitle();
        assert pageTitle.contains("Google");
    }

    @Then("I close the browser")
    public void closeBrowser() {
        // Fechar o navegador
        driver.quit();
    }
}
