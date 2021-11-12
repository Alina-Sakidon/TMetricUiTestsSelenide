package WorkspaceSettings.WorkSchedule;

import API.ApiException;
import API.RestoreBD;
import MyProfileTests.BaseTest;
import PageObjects.CreateYourWorkspacePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActivityAndScreenshots extends BaseTest {
    @Test(priority = 1,alwaysRun = true)
    public void _4729_activityAndScreenshotsTest() throws InterruptedException, IOException, ApiException {
        RestoreBD.restoreDB("NewWorkweek");
        CreateYourWorkspacePage activityAndScreenshotsPage = goToLoginPage()
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
                .selectIndustryEcommerce()
                .selectTeamSize10_15()
                .turnOnNotification();


               /* .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openGeneralWorkspaceSettingsPage().goToActivityAndScreenshotsPage();
        Assert.assertTrue(activityAndScreenshotsPage.isTitleActivityAndScreenshotsCaptureDisplayed());*/
}}
