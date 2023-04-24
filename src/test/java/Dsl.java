import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Dsl {
    public WebDriver driver;

    public Dsl(WebDriver driver) {
        this.driver = driver;
    }

    public void click(String id_campo) {
        driver.findElement(By.id(id_campo)).click();
    }

    public void escreverById(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

    public void escreverByXpath(String id_campo, String texto) {
        driver.findElement(By.xpath(id_campo)).sendKeys(texto);
    }

    public void esperarEClicar(Integer segundos, String texto) {
        WebDriverWait wait = new WebDriverWait(driver, segundos);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(texto)));
    }

    public WebElement buscarElementoById(String texto) {
        return driver.findElement(By.id(texto));

    }

    public WebElement buscarElementoByXpath(String texto) {
        return driver.findElement(By.xpath(texto));

    }

    public void tempoCarrementoPagina(Integer segundos) {
        driver.manage().timeouts().pageLoadTimeout(segundos, TimeUnit.SECONDS);

    }

    public void esperarPaginaAbrir(Integer segundos) {
        driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);

    }

    public boolean checarElementoByName(String className, String nome) {
        return driver.findElement(By.className(className)).getText().contains(nome);

    }

    public void fecharNavegador() {
        driver.quit();

    }

}
