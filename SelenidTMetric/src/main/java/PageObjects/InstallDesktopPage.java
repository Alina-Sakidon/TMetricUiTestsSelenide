package PageObjects;

import PageObjects.Components.Header;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InstallDesktopPage extends BasePage{

    private SelenideElement downloadDesktopButton = $x("//a[contains(text(),\"Download Desktop App\")]");
    private SelenideElement skipDownloadDesktop = $x("//a[contains(text(),\"Skip this step\")]");

    public Header header;
    public InstallDesktopPage(){
        header = new Header("Use Tracking Reminders and Measure Your Activity");
    }
    public MyTimePage skipDownloadDesktop()  {
        skipDownloadDesktop.shouldBe(Condition.visible).click();
        return new MyTimePage();
    }
}
