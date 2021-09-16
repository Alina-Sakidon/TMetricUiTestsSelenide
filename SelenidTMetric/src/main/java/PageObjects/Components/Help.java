package PageObjects.Components;


import PageObjects.HelpPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Help {
    private SelenideElement linkToHelpPage = $x("//span[text()='Help']");

    public HelpPage goToHelpPage(){
        linkToHelpPage.should(Condition.visible).click();
        return new HelpPage();
    }
}
