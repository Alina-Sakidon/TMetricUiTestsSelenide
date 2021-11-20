package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DeleteWorkspacePage extends BasePage{
    private final LeftSideMenu leftSideMenu;
    private SelenideElement pageTitle = $x("//div[@class=\"page-title ng-binding ng-scope\"]");

    public DeleteWorkspacePage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }

    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isPageTitleContainsWorkspaceName(String workspaceName){
        pageTitle.shouldBe(Condition.visible).shouldHave(Condition.matchText("Delete Workspace '"+workspaceName+"'"));
        return true;
    }
}