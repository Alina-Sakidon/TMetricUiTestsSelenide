package PageObjects.Components;

import PageObjects.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header extends BasePage {
    private SelenideElement headerWrapper = $x("//div[@class=\"card-header pb-0 text-center\"]");
    private SelenideElement logoTMetric = $x("//img[@src=\"/images/tmetric_logo_and_text.svg\"]");
    private SelenideElement pageTitle = headerWrapper.$("h1");

    public Header(String pageTitleName) {
        headerWrapper.should(Condition.exist);
        logoTMetric.shouldBe(Condition.visible);
        pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text(pageTitleName));
    }
}
