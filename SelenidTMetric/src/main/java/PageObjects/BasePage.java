package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

public class BasePage {

    protected void setValue(SelenideElement element, String value) {
        element.clear();
        element.setValue(value);
    }
    protected boolean isElementVisible(SelenideElement element,String text){
        element.should(Condition.visible).should(Condition.matchText(text));
        return element.isDisplayed();
    }
    protected boolean isBorderRed(SelenideElement element){
        return Color.fromString(element.getCssValue("border-color")).asHex().equals("#ff4f42");
    }
    protected boolean isTextRed(SelenideElement element){
        return Color.fromString(element.getCssValue("color")).asHex().equals("#ff4f42");
    }

}
