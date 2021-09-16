package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InvoicesPage extends BasePage{
    private SelenideElement pageTitle = $x("//span[text()='Invoices']");
    private final LeftSideMenu leftSideMenu;

    public InvoicesPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isActivityPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Invoices"));
        return pageTitle.isDisplayed();
    }
}
