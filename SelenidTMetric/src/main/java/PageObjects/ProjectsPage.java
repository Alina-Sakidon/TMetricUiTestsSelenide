package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectsPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[@class='ng-binding' and text()='Projects']");
    private final LeftSideMenu leftSideMenu;

    public ProjectsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isProjectsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Projects"));
        return pageTitle.isDisplayed();
    }
}
