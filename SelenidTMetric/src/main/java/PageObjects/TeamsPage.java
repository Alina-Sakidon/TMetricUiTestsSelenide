package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TeamsPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()=' Teams ']");
    private final LeftSideMenu leftSideMenu;

    public TeamsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isTeamsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText(" Teams "));
        return pageTitle.isDisplayed();
    }
}
