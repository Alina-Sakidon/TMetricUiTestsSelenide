package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TasksSummaryPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Tasks Summary']");
    private final LeftSideMenu leftSideMenu;

    public TasksSummaryPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTasksSummaryPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Tasks Summary"));
        return pageTitle.isDisplayed();
    }
}
