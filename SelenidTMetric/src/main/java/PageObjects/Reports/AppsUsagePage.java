package PageObjects.Reports;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AppsUsagePage extends BasePage {
    private SelenideElement pageTitle = $x("//span[text()='Apps Usage']");
    private final LeftSideMenu leftSideMenu;

    public AppsUsagePage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isAppsUsagePageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Apps Usage"));
        return pageTitle.isDisplayed();
    }
}
