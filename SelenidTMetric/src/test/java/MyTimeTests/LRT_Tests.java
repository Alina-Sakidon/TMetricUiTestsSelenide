package MyTimeTests;

import API.ApiException;
import MyProfileTests.BaseTest;
import PageObjects.MyTimePage;
import PageObjects.RestoreDbPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LRT_Tests extends BaseTest {
    @Test
    public void TT_2565_DeleteLrt () throws IOException, ApiException, InterruptedException {
        RestoreDbPage restoreDbPade  = restoreSqlBase("Shared!Layout");
        Assert.assertTrue(restoreDbPade.successRestoreDB());
        MyTimePage myTimePage = goToLoginPage()
                .setEmailAndPassword("alexanderK@devart.com","111111")
                .clickLoginButton()
                .skipBrowsExtension()
                .goToWorkspace("Devart");
        Assert.assertTrue(myTimePage.isMyTimePageVisible());
        Assert.assertTrue(myTimePage.getLrt().isLongTimerVisible());
        Assert.assertTrue(myTimePage.getLrt().isActionsButtonValid());
        Thread.sleep(1000);
        myTimePage.getLrt().deleteLRT();
        Assert.assertFalse(myTimePage.getLrt().isLongTimerVisible());
        Assert.assertTrue(myTimePage.isMyTimePageVisible());
        Assert.assertTrue(myTimePage.isDateInTimePageValid("Thu, 28 May 2015"));

    }
}
