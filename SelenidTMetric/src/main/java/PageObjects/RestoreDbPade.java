package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RestoreDbPade {
    private SelenideElement successRestoreMessage = $x("//pre[contains(text(),' database restored.')]");
    public void successRestoreDB(){
        successRestoreMessage.should(Condition.disabled);
    }
}
