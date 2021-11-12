package PageObjects.UserHotMenu.MyProfilePages;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class ChangePasswordPage extends BasePage {
    private SelenideElement pageTitle = $x("//span[contains (text(),' Change password ')]");
    private SelenideElement inputOldPassword = $(By.id("oldPassword"));
    private SelenideElement inputNewPassword = $(By.id("Password"));
    private SelenideElement inputConfirmNewPassword = $(By.id("newPasswordConfirm"));
    private SelenideElement buttonSave = $x("//button[text()=' Save ']");
    private SelenideElement buttonCancel = $x("//button[text()=' Cancel ']");
    private SelenideElement successChangePasswordMessage = $x("//span[contains (text(),'password saccessfully changed')]");
    private SelenideElement incorrectPasswordMessage = $x("//div[text()='Incorrect password.']");
    private ElementsCollection listOfRequiredCharacters = $$x("//small");


    private final LeftSideMenu leftSideMenu;

    public ChangePasswordPage(){
        super();
        leftSideMenu = new LeftSideMenu();
    }
    public LeftSideMenu menu(){
        return leftSideMenu;
    }
    public boolean isPageTitleVisible(){
        return pageTitle.shouldBe(Condition.visible).is(Condition.visible);
    }
    public ChangePasswordPage setOldPassword(String oldPassword){
        setValue(inputOldPassword,oldPassword);
        return this;
    }
    public ChangePasswordPage setNewPassword(String newPassword){
        setValue(inputNewPassword,newPassword);
        return this;
    }
    public ChangePasswordPage confirmNewPassword(String newConfirmPassword){
        setValue(inputConfirmNewPassword,newConfirmPassword);
        return this;
    }
    public SuccessChangePasswordPage savePasswordByEnter() throws InterruptedException {
        buttonSave.sendKeys(Keys.ENTER);
        return new SuccessChangePasswordPage();
    }
    public ChangePasswordPage savePassword() {
        buttonSave.click();
        return new ChangePasswordPage();
    }
    public ChangePasswordPage cancelChangedPassword(){
        buttonCancel.click();
        return new ChangePasswordPage();
    }

    public boolean isIncorrectPasswordMessageDisplayed(){
        return incorrectPasswordMessage.should(Condition.visible).isDisplayed();
    }
    public boolean isSaveButtonDisabled(){
        return buttonSave.shouldBe(Condition.disabled).is(Condition.disabled);
    }
    public boolean isBorderNewPassRed(){
       return isBorderRed(inputNewPassword);
    }
    public boolean isBorderConfirmNewPassRed(){
        return isBorderRed(inputConfirmNewPassword);
    }
    public boolean isTextOfRequiredSymbolsRed(){
        return isTextRed(listOfRequiredCharacters.find(Condition.matchText("8 or more symbols")));
    }
    public boolean isTextOfRequiredLettersRed(){
        return isTextRed(listOfRequiredCharacters.find(Condition.matchText("Letters a..z and A..Z")));
    }
    public boolean isTextOfRequiredDigitsRed(){
        return isTextRed(listOfRequiredCharacters.find(Condition.matchText("Digits 0..9")));
    }
    public boolean isTextOfRequiredCharRed(){
        return isTextRed(listOfRequiredCharacters.find(Condition.matchText("Special chars !@#$")));
    }
}
