package PageObjects.Components;

import PageObjects.MyTasksPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Tasks {
    private SelenideElement linkToMyTasksPage = $x("//span[text()='Tasks']");
    public MyTasksPage goToMyTasksPage(){
        linkToMyTasksPage.click();
        return new MyTasksPage();
    }
}
