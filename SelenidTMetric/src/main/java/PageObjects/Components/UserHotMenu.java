package PageObjects.Components;

import PageObjects.UserHotMenu.LogoutPage;
import PageObjects.UserHotMenu.ManageWorkspacePage;
import PageObjects.UserHotMenu.MyProfilePages.MyProfilePage;
import PageObjects.MyTimePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UserHotMenu {
    private SelenideElement iconToScope = $x("//img[@class='avatar-image medium']");
    private  SelenideElement linkToMyProfilePage = $x("//a[contains(text(),'My Profile')]");
    private ElementsCollection chooseWorkspacesList = $$x("//ul[@class='workspaces-list list-unstyled custom-scroll']");
    private SelenideElement linkToManageWorkspacesPage = $x("//a[contains(text(),'Manage Workspaces')]");
    private SelenideElement linkToLogoutPage = $x("//a[contains(text(),'Log Out')]");

    public MyProfilePage goToMyProfilePage(){
        actions().moveToElement(iconToScope).click().moveToElement(linkToMyProfilePage).click().build().perform();
        return new MyProfilePage();
    }
    public MyTimePage chooseWorkspaceFromUserHotMenu(String workspaceName) {
        actions().moveToElement(iconToScope.should(Condition.visible)).click().moveToElement(chooseWorkspacesList.find(Condition.text(workspaceName))).
                click().build().perform();
        return new MyTimePage();
    }
    public ManageWorkspacePage goToManageWorkspacePage(){
        actions().moveToElement(iconToScope.should(Condition.visible)).click().moveToElement(linkToManageWorkspacesPage).
                click().build().perform();
        return new ManageWorkspacePage();
    }
    public LogoutPage goToLogoutPage(){
        actions().moveToElement(iconToScope.should(Condition.visible)).click().moveToElement(linkToLogoutPage.should(Condition.visible))
                .click().build().perform();
        return new LogoutPage();
    }

}
