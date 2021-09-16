package PageObjects.UserHotMenu;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ManageWorkspacePage extends BasePage {
    private final LeftSideMenu leftSideMenu;
    private SelenideElement pageTitle = $x("//span[text()=' Manage Workspaces ']");

    public ManageWorkspacePage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isManageWorkspacePageVisible(){
        pageTitle.should(Condition.visible);
        return pageTitle.isDisplayed();
    }

}
