package MyProfileTests;

import PageObjects.LoginPage;
import PageObjects.RestoreDbPade;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        Configuration.startMaximized = true;
    }
    public RestoreDbPade restoreSqlBase(String database){
        open("https://local.tmetric.com:30000/api/tests/database/"+ database);
        return new RestoreDbPade();
    }
    public LoginPage goToLoginPage(){
        open("https://local.tmetric.com:30000");
        return new LoginPage();
    }
}
