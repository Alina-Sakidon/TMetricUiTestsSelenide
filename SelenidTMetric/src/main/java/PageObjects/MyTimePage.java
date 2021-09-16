package PageObjects;

import PageObjects.Components.LeftSideMenu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

    public class MyTimePage extends BasePage{
        private SelenideElement labelMyTimePage = $x("//div[contains(text(),'My Time')]");
        private final LeftSideMenu leftSideMenu;

         public MyTimePage(){
             super();
             leftSideMenu = new LeftSideMenu();
         }

        public LeftSideMenu menu(){
            return leftSideMenu;
        }
        public boolean isMyTimePageVisible(){
            labelMyTimePage.should(Condition.visible);
            return labelMyTimePage.isDisplayed();
        }
}
