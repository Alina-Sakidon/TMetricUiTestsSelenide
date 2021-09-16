package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WorkspaceSettingsPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()=' Workspace Settings ']");
    private final LeftSideMenu leftSideMenu;

    public WorkspaceSettingsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isWorkspaceSettingsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText(" Workspace Settings "));
        return pageTitle.isDisplayed();
    }
}
