import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonBuscadorPage {

    public Constantes constantes;
    private Dsl dsl;

    public AmazonBuscadorPage(WebDriver driver) {
        dsl = new Dsl(driver);

    }

    public void setNavMenuHamburguerPrincipalClick() {
        dsl.click("nav-hamburger-menu");

    }

    public WebElement setBuscarDropdownBox() {
        return dsl.buscarElementoById("searchDropdownBox");

    }

    public WebElement setBuscarTextoBuscador() {
        return dsl.buscarElementoByXpath("//*[@id=\"twotabsearchtextbox\"]");

    }

    public void setEscreverTextoBuscador() {
        dsl.escreverByXpath("//*[@id=\"twotabsearchtextbox\"]", "1984");

    }

    public void setClicarParaBuscarTexto() {
        dsl.click("nav-search-submit-button");

    }

    public boolean setBuscarResultados() {
        return dsl.checarElementoByName("sg-col-inner", constantes.CAMPO_RESULTADO_PARA);

    }

}
