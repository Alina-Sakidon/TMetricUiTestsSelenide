package PageObjects.TimeOff;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TimeOffRequestsPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Time Off Requests']");
    private final LeftSideMenu leftSideMenu;
    public TimeOffRequestsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTimeOffRequestsVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Time Off Requests"));
        return pageTitle.isDisplayed();
    }
}
