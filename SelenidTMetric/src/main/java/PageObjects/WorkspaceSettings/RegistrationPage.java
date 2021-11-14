package PageObjects.WorkspaceSettings;

import PageObjects.BasePage;
import PageObjects.Components.Header;
import PageObjects.ConfirmEmailAddressPage;
import PageObjects.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.hc.core5.http.message.HeaderGroup;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends BasePage {
private SelenideElement inputUserName = $(By.id("FullName"));
private SelenideElement inputUserEmail = $(By.id("Email"));
private SelenideElement inputUserPassword = $(By.id("Password"));
private SelenideElement agreeToTermsCheckbox = $(By.id("AgreeToTerms"));
private ElementsCollection signUpButtonsCollection = $$x("//button[@type=\"submit\"]");
public Header header;

public RegistrationPage(){
    header = new Header("Create Your Account");
}

    public RegistrationPage setUserName(String userName){
        setValue(inputUserName, userName);
        return this;
    }
    public RegistrationPage setUserEmail(String userEmail){
        setValue(inputUserEmail,userEmail);
        return this;
    }
    public RegistrationPage setUserPassword(String userPassword){
        setValue(inputUserPassword,userPassword);
        return this;
    }
    public RegistrationPage unableAgreeToTerms() throws InterruptedException {
        Thread.sleep(1000);
        actions().moveByOffset(agreeToTermsCheckbox.should(Condition.enabled).getLocation().getX(),agreeToTermsCheckbox.should(Condition.enabled).getLocation().getY()).click().build().perform();
        return this;
    }
    public LoginPage clickSignUpButton(){
        signUpButtonsCollection.first().click();
        return new LoginPage();
    }

}
