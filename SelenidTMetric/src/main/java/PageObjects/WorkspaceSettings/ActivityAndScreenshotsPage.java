package PageObjects.WorkspaceSettings;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ActivityAndScreenshotsPage extends BasePage {
    private final LeftSideMenu leftSideMenu;
    private ElementsCollection sections = $$x("//section[1]");
    private SelenideElement idleTimeDetection = $x("//h2[contains(text(),\"Idle Time Detection\")]");
    private SelenideElement titleActivityAndScreenshotsCapture = $x("//h2[contains(text(),\" Activity and Screenshots Capture \")]");
    public ActivityAndScreenshotsPage(){
        super();
        leftSideMenu = new LeftSideMenu();
        idleTimeDetection.shouldBe(Condition.visible);
        titleActivityAndScreenshotsCapture.shouldBe(Condition.visible);
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }

    public boolean isTitleActivityAndScreenshotsCaptureDisplayed(){
      return titleActivityAndScreenshotsCapture.isDisplayed();
    }
}

