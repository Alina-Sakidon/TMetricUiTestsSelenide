package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TagsPage extends BasePage {
    private SelenideElement pageTitle = $x("//div[text()='Tags']");

    private final LeftSideMenu leftSideMenu;

    public TagsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isTagsPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("Tags"));
        return pageTitle.isDisplayed();
    }
}
