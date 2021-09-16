package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MembersPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Members']");
    private final LeftSideMenu leftSideMenu;

    public MembersPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isMembersPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Members"));
        return pageTitle.isDisplayed();
    }
}
