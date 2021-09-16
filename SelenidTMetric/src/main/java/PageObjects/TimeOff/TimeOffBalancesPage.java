package PageObjects.TimeOff;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TimeOffBalancesPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Time Off Balances']");
    private final LeftSideMenu leftSideMenu;
    public TimeOffBalancesPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTimeOffBalancesPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Time Off Balances"));
        return pageTitle.isDisplayed();
    }

}
