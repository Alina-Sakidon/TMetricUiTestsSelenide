package PageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{
    private SelenideElement inputEmail = $(By.id("Username"));
    private SelenideElement inputPassword = $(By.id("Password"));
    private SelenideElement loginButton = $(By.id("login"));


    public LoginPage setEmailAndPassword(String email, String password) throws InterruptedException {
        setValue(inputEmail,email);
        setValue(inputPassword,password);
        return this;
    }
    public InstallBrowserExtensionPage clickLoginButton(){
        loginButton.click();
        return new InstallBrowserExtensionPage();
    }
    public InstallBrowserExtensionPage ownerAuthorization() throws InterruptedException {
        setValue(inputEmail,"owner@tmetric.test");
        setValue(inputPassword,"111111");
        loginButton.click();
        return new InstallBrowserExtensionPage();
    }


}
