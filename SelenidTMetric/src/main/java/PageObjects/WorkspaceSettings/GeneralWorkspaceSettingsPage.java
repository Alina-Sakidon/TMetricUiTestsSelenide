package PageObjects.WorkspaceSettings;

import PageObjects.BasePage;
import PageObjects.ChooseWorkspacePage;
import PageObjects.Components.ActionButton;
import PageObjects.Components.LeftSideMenu;
import PageObjects.DeleteWorkspacePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GeneralWorkspaceSettingsPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()=' Workspace Settings ']");
    private ElementsCollection settingsSections = $$x("//div[@class='flex-column']//a");
    private final LeftSideMenu leftSideMenu;
    private final ActionButton actionButton;

    public GeneralWorkspaceSettingsPage(){
        super();
       // settingsSections.should(CollectionCondition.itemWithText(String.valueOf(Condition.exist)));
        leftSideMenu = new LeftSideMenu();
        actionButton = new ActionButton();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isWorkspaceSettingsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText(" Workspace Settings "));
        return pageTitle.isDisplayed();
    }
    public ActivityAndScreenshotsPage goToActivityAndScreenshotsPage(){
        settingsSections.findBy(Condition.text("Activity and Screenshots")).shouldBe(Condition.visible).click();
        return new ActivityAndScreenshotsPage();
    }
    public ActionButton getActionButton(){return actionButton;}

    public DeleteWorkspacePage deleteWorkspase() {
        return actionButton.openActionMenu(" Delete Workspace ", new DeleteWorkspacePage());
    }
}
