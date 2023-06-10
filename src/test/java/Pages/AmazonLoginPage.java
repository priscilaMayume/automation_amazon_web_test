package Pages;

import Constantes.Constantes;
import Dsl.Dsl;
import org.openqa.selenium.WebDriver;

public class AmazonLoginPage {
    public Constantes constantes;
    private Dsl dsl;
    private AmazonLoginPage page;

    String navAccountList = "nav-link-accountList";
    String apEmail = "ap_email";
    String continuar = "continue";
    String psw = "ap_password";
    String signInSubmit = "signInSubmit";
    String saudacaoPersonalizada = "nav-link-accountList-nav-line-1";
    String erroMsgEmailIvalido = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span";
    String erroMsgPswIvalido = "a-list-item";

    public AmazonLoginPage(WebDriver driver) {
        dsl = new Dsl(driver);

    }

    public void setAccountClick() {
        dsl.click(navAccountList);
    }

    public void setEscreverLogin() {
        dsl.escreverById(apEmail, Constantes.EMAL_VALIDO);
    }

    public void setClickContinuar() {
        dsl.click(continuar);
    }

    public void setEscreverPswValido() {
        dsl.escreverById(psw, Constantes.PSW_VALIDO);
    }

    public void setSignInSubmitClick() {
        dsl.click(signInSubmit);
    }

    public boolean setCheckSaudacao() {
        return dsl.checarElementoById(saudacaoPersonalizada, constantes.SAUDACAO_JOSE);
    }

    public void setEscreverLoginInvalido() {
        dsl.escreverById(apEmail, Constantes.EMAL_INVALIDO);
    }

    public boolean setCheckErroEmailInvalido() {
        return dsl.checarElementoByXpath(erroMsgEmailIvalido, constantes.MSG_EXCECAO_EMAIL);

    }

    public void setEscreverPswInvalido() {
        dsl.escreverById(psw, Constantes.PSW_INVALIDO);
    }

    public boolean setCheckErroPswInvalido() {
        return dsl.checarElementoByClass(erroMsgPswIvalido, constantes.MSG_EXCECAO_PSW);

    }

}
