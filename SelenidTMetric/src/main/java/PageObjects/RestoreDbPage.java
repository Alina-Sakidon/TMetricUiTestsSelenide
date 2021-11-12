package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.common.io.BaseEncoding;

import static com.codeborne.selenide.Selenide.$x;

public class RestoreDbPage {
    private SelenideElement successRestoreMessage = $x("//pre[contains(text(),' database restored.')]");
    public boolean successRestoreDB(){
        return successRestoreMessage.shouldBe(Condition.visible).isDisplayed();
    }
}
