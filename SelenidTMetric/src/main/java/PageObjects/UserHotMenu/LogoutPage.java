package PageObjects.UserHotMenu;

import PageObjects.BasePage;
import PageObjects.Components.Header;
import PageObjects.Components.LeftSideMenu;
import PageObjects.LoginPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogoutPage extends BasePage {
    private SelenideElement pageTitle = $x("//h1[text()='Logout']");
    private SelenideElement buttonProceedToLogin = $x("//a[text()='Proceed to Login']");
    private final LeftSideMenu leftSideMenu;
    public Header header;

    public LogoutPage(){
        super();
        leftSideMenu = new LeftSideMenu();
        header = new Header("Logout");
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isLogoutPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Logout"));
        return pageTitle.isDisplayed();
    }
    public LoginPage goToLoginPage(){
        buttonProceedToLogin.should(Condition.visible).click();
        return new LoginPage();
    }
}
