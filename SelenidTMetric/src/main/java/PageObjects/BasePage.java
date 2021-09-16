package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

    protected void setValue(SelenideElement element, String value) throws InterruptedException {
        element.clear();
        element.setValue(value);
        //element.sendKeys(value);
    }
    protected boolean isElementVisible(SelenideElement element,String text){
        element.should(Condition.visible).should(Condition.matchText(text));
        return element.isDisplayed();
    }


    //protected abstract LeftSideMenu generateSideMenu();

    /*public BasePage open(MenuPageType type)
    {
        var menu = getSideMenu();
        if(menu != null) {
         return menu.open(type);
        }
        return null;
    }*/
}
