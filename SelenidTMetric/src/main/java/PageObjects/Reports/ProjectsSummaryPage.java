package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsSummaryPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Projects Summary']");
    private final LeftSideMenu leftSideMenu;

    public ProjectsSummaryPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isProjectsSummaryPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Projects Summary"));
        return pageTitle.isDisplayed();
    }
}
