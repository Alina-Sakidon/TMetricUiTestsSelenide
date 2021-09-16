package PageObjects.Components;

import PageObjects.MyTimePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Time {
    private SelenideElement linkToMyTimePage = $x("//span[text()='Time']");
    public MyTimePage goToMyTimePage(){
        linkToMyTimePage.click();
        return new MyTimePage();
    }
}
