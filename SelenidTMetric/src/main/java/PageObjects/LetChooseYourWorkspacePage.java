package PageObjects;

import PageObjects.Components.Header;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LetChooseYourWorkspacePage extends BasePage{
    private SelenideElement pageTitle = $x("//h1");
    private ElementsCollection actionButtons = $$x("//i");
    public Header header;

    public LetChooseYourWorkspacePage(){
        header = new Header("Let's choose your workspace");
    }

    public boolean isPageTitleDisplayed(){
        pageTitle.shouldBe(Condition.visible);
        return true;
    }
    public CreateYourWorkspacePage clickCreateYourWorkspace(){
        actionButtons.should(CollectionCondition.sizeGreaterThan(1)).first().click();
        return new CreateYourWorkspacePage();
    }
}
