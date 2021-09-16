package PageObjects.TimeOff;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TimeOffCalendarPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()='Time Off Calendar']");
    private final LeftSideMenu leftSideMenu;
    public TimeOffCalendarPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTimeOffCalendarPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Time Off Calendar"));
        return pageTitle.isDisplayed();
    }
}
