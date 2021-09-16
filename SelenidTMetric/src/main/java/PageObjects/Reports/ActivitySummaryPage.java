package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ActivitySummaryPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Activity Summary']");
    private final LeftSideMenu leftSideMenu;
    public ActivitySummaryPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isActivitySummaryPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("ActivitySummary"));
        return pageTitle.isDisplayed();
    }
}
