package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IntegrationsPage extends BasePage{
    private SelenideElement pageTitle = $x("//span[text()='Integrations']");
    private final LeftSideMenu leftSideMenu;

    public IntegrationsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isIntegrationsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText(" Integrations "));
        return pageTitle.isDisplayed();
    }
}
