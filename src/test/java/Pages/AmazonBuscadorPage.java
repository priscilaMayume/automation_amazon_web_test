package Pages;

import Constantes.Constantes;
import Dsl.Dsl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonBuscadorPage {

    public Constantes constantes;
    private Dsl dsl;
    String menuHambueger = "nav-hamburger-menu";
    String searchDropdownBox = "searchDropdownBox";
    String searchTextBox = "//*[@id=\"twotabsearchtextbox\"]";
    String submitButton = "nav-search-submit-button";
    String sgColInner = "sg-col-inner";

    public AmazonBuscadorPage(WebDriver driver) {
        dsl = new Dsl(driver);

    }

    public void setNavMenuHamburguerPrincipalClick() {
        dsl.click(menuHambueger);

    }

    public WebElement setBuscarDropdownBox() {
        return dsl.buscarElementoById(searchDropdownBox);

    }

    public WebElement setBuscarTextoBuscador() {
        return dsl.buscarElementoByXpath(searchTextBox);

    }

    public void setEscreverTextoBuscador() {
        dsl.escreverByXpath(searchTextBox, Constantes.L_1984);

    }

    public void setClicarParaBuscarTexto() {
        dsl.click(submitButton);

    }

    public boolean setBuscarResultados() {
        return dsl.checarElementoByName(sgColInner, constantes.CAMPO_RESULTADO_PARA);

    }

}
