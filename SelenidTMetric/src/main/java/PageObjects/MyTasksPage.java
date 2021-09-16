package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MyTasksPage extends BasePage  {
    private final LeftSideMenu leftSideMenu;
    private SelenideElement pageTitle = $x("//div[text()='My Tasks']");

    public MyTasksPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isMyTasksPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("My Tasks")).click();
        return pageTitle.isDisplayed();
    }
}
