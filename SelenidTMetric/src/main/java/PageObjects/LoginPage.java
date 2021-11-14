package PageObjects;

import PageObjects.Components.Header;
import PageObjects.WorkspaceSettings.RegistrationPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage{
    private SelenideElement inputEmail = $(By.id("Username"));
    private SelenideElement inputPassword = $(By.id("Password"));
    private SelenideElement loginButton = $(By.id("login"));
    private SelenideElement signUpLink = $x("//a[contains(text(),'Sign Up')]");
    public Header header;

    public LoginPage(){
        header = new Header("Log into TMetric");
    }


    public LoginPage setEmailAndPassword(String email, String password) throws InterruptedException {
        setValue(inputEmail,email);
        setValue(inputPassword,password);
        return this;
    }
    public InstallBrowserExtensionPage clickLoginButton(){
        loginButton.click();
        return new InstallBrowserExtensionPage();
    }
    public LetChooseYourWorkspacePage loginLetChooseWorkspacePage(){
        loginButton.click();
        return new LetChooseYourWorkspacePage();
    }
    public InstallBrowserExtensionPage ownerAuthorization(){
        setValue(inputEmail,"owner@tmetric.test");
        setValue(inputPassword,"111111");
        loginButton.click();
        return new InstallBrowserExtensionPage();
    }
    public RegistrationPage goToRegistrationPage(){
        signUpLink.shouldBe(Condition.visible).click();
        return new RegistrationPage();
    }


}
