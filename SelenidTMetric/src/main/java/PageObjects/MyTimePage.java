package PageObjects;

import PageObjects.Components.LeftSideMenu;
import PageObjects.Components.MyTime.LRT;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

    public class MyTimePage extends BasePage{
        private SelenideElement labelMyTimePage = $x("//div[contains(text(),'My Time')]");
        private SelenideElement dateInTimePage = $$x("//span[@class=\"ng-binding ng-scope\"]").first();
        private final LeftSideMenu leftSideMenu;
        private LRT ltr;

         public MyTimePage()  {
             super();
             leftSideMenu = new LeftSideMenu();
             ltr = new LRT();
         }
        public LRT getLrt(){
            return ltr;
        }
        public LeftSideMenu menu(){
            return leftSideMenu;
        }


        public boolean isMyTimePageVisible(){
            labelMyTimePage.should(Condition.visible);
            return labelMyTimePage.isDisplayed();
        }
        public boolean isDateInTimePageValid(String date){
             dateInTimePage.shouldHave(Condition.text(date));
             return true;
        }

}
