package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TeamSummaryPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Team Summary']");
    private final LeftSideMenu leftSideMenu;

    public TeamSummaryPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }

    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTeamSummaryPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Team Summary"));
        return pageTitle.isDisplayed();
    }
}
