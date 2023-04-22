import org.openqa.selenium.WebDriver;

import java.util.WeakHashMap;

public class AmazonPage {

    private Dsl dsl;
    public AmazonPage(WebDriver driver){
        dsl = new Dsl(driver);

    }

    public void setNavMenuHamburguerPrincipalClick(){
        dsl.click("nav-hamburger-menu");

    }

}
