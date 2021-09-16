package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ChooseWorkspacePage extends BasePage{
    private final LeftSideMenu leftSideMenu;

    public ChooseWorkspacePage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu getLeftSideMenu(){
        return leftSideMenu;
    }

    private SelenideElement titleChooseWorkspacePage = $x("//span[contains(text(),'Choose Workspace ')]");
    private ElementsCollection chooseWorkspaceTable = $$x("//table[@class='table table-hover ng-scope']//tbody");

    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isChooseWorkspacePageVisible() throws InterruptedException {
        titleChooseWorkspacePage.should(Condition.visible);
        return titleChooseWorkspacePage.is(Condition.visible);
    }
    public MyTimePage goToWorkspace(String nameWorkspace){
        chooseWorkspaceTable.find(Condition.text(nameWorkspace)).click();
        return new MyTimePage();
    }
}
