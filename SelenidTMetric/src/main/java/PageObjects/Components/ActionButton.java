package PageObjects.Components;

import PageObjects.BasePage;
import PageObjects.WorkspaceSettings.GeneralWorkspaceSettingsPage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class ActionButton extends BasePage {
    private SelenideElement actionButton = $(By.id("btn-actions-menu"));
    private ElementsCollection actionMenuButtons=$$x("//div[@class=\"dropdown-menu dropdown-menu-right show\"]//a");

    public ActionButton(){
        actionButton.shouldBe(Condition.visible);
    }

    public <T extends BasePage> T openActionMenu(String actionText, T page){
        actionButton.click();
        actionMenuButtons.shouldBe(CollectionCondition.sizeGreaterThan(0));
        actionMenuButtons.find(Condition.text(actionText)).click();
        return page;
    }
}
