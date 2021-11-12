package MyProfileTests;

import PageObjects.LoginPage;
import PageObjects.RestoreDbPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.LocalStorage;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    private LocalStorage localStorage;
    @BeforeMethod
    public void beforeMethod(){
        Configuration.startMaximized = true;
        //clearBrowserCookies();
        closeWebDriver();
    }
    public RestoreDbPage restoreSqlBase(String database){
        open("https://local.tmetric.com:30000/api/tests/database/"+ database);
        return new RestoreDbPage();
    }
    public LoginPage goToLoginPage(){
        open("https://local.tmetric.com:30000");
        return new LoginPage();
    }
    public void clearLocalStorage(){
        localStorage.clear();
    }
}
