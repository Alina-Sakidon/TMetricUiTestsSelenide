package PageObjects;

import PageObjects.Components.Header;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InstallBrowserExtensionPage extends BasePage{
    private SelenideElement browsExtensionSkipButton = $x("//a[contains(text(),'Skip this step')]");
    public Header header;

    public InstallBrowserExtensionPage(){
        header = new Header("Integrate Time Tracking Into Your Workflow");
    }

    public ChooseWorkspacePage skipBrowsExtension(){
        browsExtensionSkipButton.should(Condition.visible).click();
        return new ChooseWorkspacePage();
    }
    public InstallDesktopPage skipBrowsExtensionByRegistration(){
        browsExtensionSkipButton.shouldBe(Condition.visible).click();
        return new InstallDesktopPage();
    }
}
