package Pages;

import Constantes.Constantes;
import Dsl.Dsl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class AmazonBuscadorPage {

    public Constantes constantes;
    private Dsl dsl;
    String menuHambueger = "nav-hamburger-menu";
    String searchDropdownBoxXPath = "//*[@id=\"nav-search-dropdown-card\"]/div";
    String searchDropdownBox = "//*[@id=\"searchDropdownBox\"]";
    String searchTextBox = "//*[@id=\"twotabsearchtextbox\"]";
    String submitButton = "nav-search-submit-button";
    String sgColInner = "sg-col-inner";

    public AmazonBuscadorPage(WebDriver driver) {
        dsl = new Dsl(driver);

    }

    public void setNavMenuHamburguerPrincipalClick() {
        dsl.clickById(menuHambueger);

    }

    public void setMenuHamburguerPrincipalMover() {
        dsl.moverById(menuHambueger);

    }

    public void setDropDownBoxPrincipalClick() {
        dsl.moverByXPath(searchDropdownBoxXPath);
        dsl.clickByXPath(searchDropdownBoxXPath);

    }

    public WebElement setBuscarDropdownBox() {
        return dsl.buscarElementoByXpath(searchDropdownBox);

    }

    public WebElement setBuscarTextoBuscador() {
        return dsl.buscarElementoByXpath(searchTextBox);

    }

    public void setEscreverTextoBuscador() {
        dsl.escreverByXpath(searchTextBox, Constantes.L_1984);

    }

    public void setClicarParaBuscarTexto() {
        dsl.clickById(submitButton);

    }

    public boolean setBuscarResultados() {
        return dsl.checarElementoByName(sgColInner, constantes.CAMPO_RESULTADO_PARA);

    }

}
