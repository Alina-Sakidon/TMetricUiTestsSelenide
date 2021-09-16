package PageObjects.TimeOff;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TimeOffPoliciesPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()=' Time Off Policies ']");
    private final LeftSideMenu leftSideMenu;
    public TimeOffPoliciesPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTeamSummaryPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Time Off Policies"));
        return pageTitle.isDisplayed();
    }
}
