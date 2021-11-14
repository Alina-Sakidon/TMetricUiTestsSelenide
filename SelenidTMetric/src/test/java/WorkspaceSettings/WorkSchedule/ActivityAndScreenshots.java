package WorkspaceSettings.WorkSchedule;

import API.ApiException;
import API.RestoreBD;
import MyProfileTests.BaseTest;
import PageObjects.MyTimePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivityAndScreenshots extends BaseTest {
    @Test(priority = 1,alwaysRun = true)
    public void _4729_activityAndScreenshotsTest() throws InterruptedException, IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        MyTimePage myTimePage = goToLoginPage()
                .goToRegistrationPage()
                .setUserName("Ivan Ivanov")
                .setUserEmail("test@tmetric.test")
                .setUserPassword("111111")
                .unableAgreeToTerms()
                .clickSignUpButton()
                .setEmailAndPassword("test@tmetric.test","111111")
                .loginLetChooseWorkspacePage()
                .clickCreateYourWorkspace()
                .setCompanyName("qwerty")
                .selectIndustry("E-commerce")
                .selectTeamSize("2-5")
                .turnOnNotification()
                .clickCreateButton()
                .skipBrowsExtensionByRegistration()
                .skipDownloadDesktop();
        Assert.assertTrue(myTimePage.isMyTimePageVisible());

               /* .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openGeneralWorkspaceSettingsPage().goToActivityAndScreenshotsPage();
        Assert.assertTrue(activityAndScreenshotsPage.isTitleActivityAndScreenshotsCaptureDisplayed());*/
}}
