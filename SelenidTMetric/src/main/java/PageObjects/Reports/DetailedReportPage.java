package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DetailedReportPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Detailed Report']");
    private final LeftSideMenu leftSideMenu;

    public DetailedReportPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isDetailedReportVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Detailed Report"));
        return pageTitle.isDisplayed();
    }
}
