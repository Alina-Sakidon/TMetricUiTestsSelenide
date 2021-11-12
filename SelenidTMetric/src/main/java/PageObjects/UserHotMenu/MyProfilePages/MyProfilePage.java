package PageObjects.UserHotMenu.MyProfilePages;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class MyProfilePage extends BasePage {
    private SelenideElement pageTitle = $x("//div[@class='page-title d-flex align-items-center ng-binding']");

    private SelenideElement savingMenu = $x("//div[@class='editor-footer d-flex align-items-center justify-content-between ng-scope visible']");
    private SelenideElement saveButton = $x("//button[@type='submit']");
    private SelenideElement cancelButton = $x("//button[text()=' Cancel ']");
    private SelenideElement textOfSavingMenu = $x("//div[@class='editor-footer-text']//span");

    private SelenideElement inputName = $x("//div[@class='form-group'][2]//div//div//input");
    private SelenideElement inputEmail = $x("//div[@class='form-group'][3]//div//div//input");

    private SelenideElement linkToChangeButtonPage = $x("//a[contains (text(),' Change password ')]");
    private final LeftSideMenu leftSideMenu;

    public MyProfilePage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean allLabelsVisible(){
        return isElementVisible(savingMenu," Press Ctrl+Enter to save changes ") &&
                isElementVisible(pageTitle," My Profile ");
    }

    public boolean isMyProfilePageVisible(){
        pageTitle.should(Condition.visible).should(Condition.matchText("My Profile"));
        return pageTitle.isDisplayed();
    }
    public boolean isSavingMenuVisible(){
        return savingMenu.should(Condition.visible).isDisplayed();
    }
    public MyProfilePage saveChanges() throws InterruptedException {
        actions().moveToElement(saveButton.should(Condition.visible).should(Condition.matchText("Save")))
                .click().build().perform();
        //Thread.sleep(2000);
        return new MyProfilePage();
    }
    public MyProfilePage cancelButton(){
        actions().moveToElement(cancelButton.should(Condition.visible).should(Condition.matchText(" Cancel ")))
                .click().build().perform();
        return new MyProfilePage();
    }
    public MyProfilePage setName(String name) throws InterruptedException {
         setValue(inputName,name);
         Thread.sleep(1000);
         return this;
    }
    public boolean isgBorderRed(){
        inputName.shouldHave(Condition.cssValue("border-color", (new Color(255,79,66, 0.0).asRgb())));
       return Color.fromString(inputName.getCssValue("border-color")).asHex().equals("#ff4f42");
    }
    public ChangePasswordPage goToChangePasswordPage(){
        linkToChangeButtonPage.should(Condition.visible).click();
        return new ChangePasswordPage();
    }
}
