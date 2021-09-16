package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InstallBrowserExtensionPage extends BasePage{
    private SelenideElement browsExtensionSkipButton = $x("//a[contains(text(),'Skip this step')]");

    public ChooseWorkspacePage skipBrowsExtension(){
        browsExtensionSkipButton.should(Condition.visible).click();
        return new ChooseWorkspacePage();
    }
}
