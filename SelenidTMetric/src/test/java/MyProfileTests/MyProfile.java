package MyProfileTests;

import API.ApiException;
import API.RestoreBD;
import PageObjects.MyTimePage;
import PageObjects.RestoreDbPage;
import PageObjects.UserHotMenu.MyProfilePages.ChangePasswordPage;
import PageObjects.UserHotMenu.MyProfilePages.MyProfilePage;
import PageObjects.UserHotMenu.MyProfilePages.SuccessChangePasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyProfile extends BaseTest {
    @Test(priority = 1,alwaysRun = true)
    public void profileTest() throws InterruptedException {
        RestoreDbPage restoreDbPage = restoreSqlBase("NewWorkweek");
        Assert.assertTrue(restoreDbPage.successRestoreDB());
        MyTimePage myTimePage = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings");

    }
    @Test(priority = 2,alwaysRun = true)
    public void test_470() throws InterruptedException, IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        MyProfilePage myProfile = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile();
        Assert.assertTrue(myProfile.isMyProfilePageVisible());
        myProfile.setName("").saveChanges();
        Assert.assertTrue(myProfile.isgBorderRed());
        Assert.assertTrue(myProfile.isSavingMenuVisible());
    }
    @Test(priority = 3)
    public void changeValidPassword_492() throws InterruptedException, IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        SuccessChangePasswordPage successChangePasswordPage = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile()
                .goToChangePasswordPage()
                .setOldPassword("111111")
                .setNewPassword("!Devart2019")
                .confirmNewPassword("!Devart2019")
                .savePasswordByEnter();
        Assert.assertTrue(successChangePasswordPage.isSuccessMessageDisplayed());
       MyProfilePage myProfilePage = new MyProfilePage();
        Assert.assertTrue(myProfilePage.isMyProfilePageVisible());
        myProfilePage.menu()
                .openTime().isMyTimePageVisible();
    }
    @Test
    public void cancelChangedPassword_493() throws IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        ChangePasswordPage changePasswordPage = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile()
                .goToChangePasswordPage()
                .setOldPassword("111111")
                .setNewPassword("!Devart2019")
                .confirmNewPassword("!Devart2019")
                .cancelChangedPassword();
        MyProfilePage myProfilePage = new MyProfilePage();
        Assert.assertTrue(myProfilePage.isMyProfilePageVisible());
    }
    @Test
    public void cancelPasswordWithWrongOldPass_494() throws IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        ChangePasswordPage changePasswordPage = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile()
                .goToChangePasswordPage()
                .setOldPassword("0000")
                .setNewPassword("!Devart2019")
                .confirmNewPassword("!Devart2019")
                .savePassword();
        Assert.assertTrue(changePasswordPage.isIncorrectPasswordMessageDisplayed());
    }
    @Test
    public void inputInvalidPass_495() throws IOException, ApiException {
        //RestoreDbPade restoreDbPade  = restoreSqlBase("NewWorkweek");
       // Assert.assertTrue(restoreDbPade.successRestoreDB());

        RestoreBD.restoreDB("NewWorkweek");
        ChangePasswordPage changePasswordPage = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile()
                .goToChangePasswordPage()
                .setNewPassword("QWEas1!");
        Assert.assertTrue(changePasswordPage.isSaveButtonDisabled());
                changePasswordPage.confirmNewPassword("QWEas1!");
        Assert.assertTrue(changePasswordPage.isTextOfRequiredSymbolsRed());
    }

}
