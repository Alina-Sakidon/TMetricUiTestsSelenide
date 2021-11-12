package PageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CreateYourWorkspacePage extends BasePage{
private SelenideElement companyNameInput = $(By.id("CompanyName"));
private ElementsCollection selectors = $$x("//b");
private SelenideElement industryEcommerce = $x("//li[contains (text(),\"E-commerce\")]");
private ElementsCollection listOfElements = $$x("li");
private SelenideElement teamSize10_15 = $x("//li[contains(text(),\"10-39\")]");
private SelenideElement inputTurnOnNotifications = $(By.id("MailingConsentYes"));
private SelenideElement createButton = $x("//button[@type=\"submit\"]");

public CreateYourWorkspacePage setCompanyName(String name){
    setValue(companyNameInput,name);
    return this;
}
public CreateYourWorkspacePage selectIndustryEcommerce(){
   selectors.shouldBe(CollectionCondition.sizeGreaterThan(1)).first().click();
   actions().moveToElement(industryEcommerce).click().build().perform();
    return this;
}

public  CreateYourWorkspacePage selectTeamSize10_15(){
    selectors.shouldBe(CollectionCondition.sizeGreaterThan(1)).last().click();
    actions().moveToElement(teamSize10_15).click().build().perform();
    return this;
}
public CreateYourWorkspacePage turnOnNotification(){
    inputTurnOnNotifications.shouldBe(Condition.enabled).click();
    return this;
}
public CreateYourWorkspacePage clickCreateButton(){
     createButton.shouldBe(Condition.enabled).click();
     return this;
}
}
