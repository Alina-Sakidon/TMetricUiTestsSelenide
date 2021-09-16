package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyActivityPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()='My Activity']");
    private final LeftSideMenu leftSideMenu;

    public MyActivityPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isActivityPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("My Activity"));
        return pageTitle.isDisplayed();
    }
}
