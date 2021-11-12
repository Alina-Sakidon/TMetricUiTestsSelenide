package PageObjects.UserHotMenu.MyProfilePages;

import PageObjects.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessChangePasswordPage extends BasePage {
    private SelenideElement successChangePassMessage = $x("//div[contains(text(),'Password successfully changed')]");
    public boolean isSuccessMessageDisplayed(){
        successChangePassMessage.shouldBe(Condition.visible);
        return successChangePassMessage.isDisplayed();
    }
}
