package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HelpPage extends BasePage {
    public HelpPage(){
        super();
    }
    private SelenideElement pageTitle = $x("//h3[text()='TMetric Documentation']");

    public boolean isHelpPageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("TMetric Documentation"));
        return pageTitle.isDisplayed();
    }
}
