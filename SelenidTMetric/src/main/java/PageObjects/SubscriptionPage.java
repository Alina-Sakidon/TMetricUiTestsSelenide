package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SubscriptionPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()=' Subscription ']");
    private final LeftSideMenu leftSideMenu;
    public SubscriptionPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isMembersPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText(" Subscription "));
        return pageTitle.isDisplayed();
    }
}
