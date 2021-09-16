package PageObjects.UserHotMenu;

import PageObjects.BasePage;
import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class MyProfilePage extends BasePage {
    private SelenideElement pageTitle = $x("//div[@class='page-title d-flex align-items-center ng-binding']");
    private SelenideElement savingMenu = $x("//div[@class='editor-footer d-flex align-items-center justify-content-between ng-scope visible']");
    private SelenideElement saveButton = $x("//button[@type='submit']");
    private SelenideElement cancelButton = $x("//button[text()=' Cancel ']");
    private SelenideElement inputNameNotEmpty = $x("//input[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength']");
    private SelenideElement inputNameEmpty = $x("//input[@class='form-control ng-valid ng-valid-maxlength ng-dirty ng-touched ng-valid-parse ng-empty']");
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
        savingMenu.should(Condition.visible).should(Condition.matchText(" Press Ctrl+Enter to save changes "));
        return savingMenu.isDisplayed();
    }
    public MyProfilePage saveChanges(){
        actions().moveToElement(saveButton.should(Condition.visible).should(Condition.matchText("Save")))
                .click().build().perform();
        return new MyProfilePage();
    }
    public MyProfilePage cancelButton(){
        actions().moveToElement(cancelButton.should(Condition.visible).should(Condition.matchText(" Cancel ")))
                .click().build().perform();
        return new MyProfilePage();
    }
    public MyProfilePage setName(String name) throws InterruptedException {
         setValue(inputNameNotEmpty,name);
         return this;
    }
    public MyProfilePage clear(){
        inputNameNotEmpty.should(Condition.visible).clear();
        return new MyProfilePage();
    }
    public MyProfilePage set(String name){
        inputNameEmpty.should(Condition.visible).click();
        inputNameEmpty.setValue(name);
        return new MyProfilePage();
    }
    public boolean isgBorderRed(){
        inputNameNotEmpty.getCssValue("border-color").contains("#ff4f42");
        return inputNameNotEmpty.isDisplayed();
    }
}
