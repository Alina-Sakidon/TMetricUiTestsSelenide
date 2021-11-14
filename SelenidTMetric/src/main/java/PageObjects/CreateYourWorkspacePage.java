package PageObjects;

import PageObjects.Components.Header;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class CreateYourWorkspacePage extends BasePage{
private SelenideElement companyNameInput = $(By.id("CompanyName"));
private ElementsCollection selectors = $$x("//b");
private SelenideElement industryEcommerce = $x("//li[contains (text(),\"E-commerce\")]");
private ElementsCollection listOfIndustries = $$(By.id("select2-CompanyIndustryIndex-results"));
private ElementsCollection listOfTeamSize = $$(By.id("select2-CompanySize-results"));
private SelenideElement teamSize10_15 = $x("//li[contains(text(),\"10-39\")]");
private SelenideElement inputTurnOnNotifications = $x("//label[@for=\"MailingConsentYes\"]");
private SelenideElement createButton = $x("//button[@type=\"submit\"]");
private SelenideElement radioButtonYesNotification = $x("//input[@id=\"MailingConsentYes\"]");
private SelenideElement radioButtonNoNotification = $x("//input[@id=\"MailingConsentNo\"]");
public Header header;

public CreateYourWorkspacePage(){
    header = new Header("Create Your Workspace");
}

public CreateYourWorkspacePage setCompanyName(String name){
    setValue(companyNameInput,name);
    return this;
}
public CreateYourWorkspacePage selectIndustry(String industry){
   selectors.shouldBe(CollectionCondition.size(2)).first().click();
  listOfIndustries.shouldBe(CollectionCondition.sizeGreaterThan(0)).find(Condition.text(industry)).click();
    return this;
}

public  CreateYourWorkspacePage selectTeamSize(String teamSize){
    selectors.shouldBe(CollectionCondition.sizeGreaterThan(1)).last().click();
    listOfTeamSize.should(CollectionCondition.sizeGreaterThan(0)).find(Condition.text(teamSize)).click();
    return this;
}
public CreateYourWorkspacePage turnOnNotification()  {
    radioButtonYesNotification.shouldNotBe(Condition.selected);
     inputTurnOnNotifications.shouldBe(Condition.visible).click();
    radioButtonYesNotification.shouldBe(Condition.selected);
    radioButtonNoNotification.shouldNotBe(Condition.selected);
    return this;
}
public InstallBrowserExtensionPage clickCreateButton(){
     createButton.shouldBe(Condition.enabled).click();
     return new InstallBrowserExtensionPage();
}
}
