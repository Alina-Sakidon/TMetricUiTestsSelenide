package PageObjects.Components.MyTime;

import PageObjects.BasePage;
import PageObjects.MyTimePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;

import static com.codeborne.selenide.Selenide.*;

public class LRT extends BasePage {
    private SelenideElement ltrWrapper = $("#long-timer-form");
    private SelenideElement lrtText = $(By.tagName("h3")).lastChild();
    private SelenideElement lrtTaskName = $(".mt-2");
    private ElementsCollection lrtTimeInfo = $$(".mt-3");
    private ElementsCollection ltrActionButtons =$$(".mt-5 button");
    private SelenideElement finishedAtDateTime = $x("//a[@title=\"Click to change timer end day\"]");

    public boolean isFinishedDateTimeValid(String finishedDateTime){
        finishedAtDateTime.shouldBe(Condition.visible).shouldHave(Condition.text(finishedDateTime));
        return true;
    }
    public boolean isLongTimerVisible(){
        try {
            ltrWrapper.shouldBe(Condition.visible);
            return true;
        }
        catch (ElementNotFound e){
            return false;
        }
    }
    public boolean isActionsButtonValid(){
        boolean a = ltrActionButtons.stream().findFirst().get().shouldHave(Condition.text("Fix Timer")).getAttribute("class").contains("disabled");
        if (a){
            ltrActionButtons.find(Condition.text("Delete Timer")).shouldBe(Condition.enabled);
            return true;
        }
        return false;
    }
    public boolean isTitleLongTimerValid(){
        lrtText.shouldHave(Condition.text("Timer is running longer than 12 hours"));
        return true;
    }

    public MyTimePage deleteLRT() throws InterruptedException {
        ltrWrapper.shouldBe(Condition.visible);
        ltrActionButtons.findBy(Condition.text("Delete Timer")).click();
        ltrWrapper.shouldNotBe(Condition.visible);
        return new MyTimePage();
    }
}
