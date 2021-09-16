package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ClientsPage extends BasePage{
    private SelenideElement pageTitle = $x("//span[text()=' Clients ']");
    private final LeftSideMenu leftSideMenu;

    public ClientsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isClientsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Clients"));
        return pageTitle.isDisplayed();
    }
}
