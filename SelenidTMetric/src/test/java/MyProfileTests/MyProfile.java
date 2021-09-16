package MyProfileTests;

import PageObjects.MyTimePage;
import PageObjects.RestoreDbPade;
import PageObjects.UserHotMenu.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfile extends BaseTest {
    @Test
    public void profileTest() throws InterruptedException {
        RestoreDbPade restoreDbPade = restoreSqlBase("NewWorkweek");
        MyTimePage myProfile = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings");

         //(MyTimePage)myProfile.menu().open(MenuPageType.TIME);

    }
    @Test
    public void test470() throws InterruptedException {
        RestoreDbPade restoreDbPade = restoreSqlBase("NewWorkweek");
        MyProfilePage myProfile = goToLoginPage()
                .ownerAuthorization()
                .skipBrowsExtension()
                .goToWorkspace("Workweek with general and personal settings")
                .menu()
                .openMyProfile();
        Assert.assertTrue(myProfile.isMyProfilePageVisible());
        myProfile.clear().set("y");
        //Assert.assertTrue(myProfile.isgBorderRed());

        //MyTimePage myTimePage = myProfile
       /* MyTimePage myTimePage1 = myTimePage.menu().openMyTime();
        Assert.assertTrue(myTimePage.isMyTimePageVisible());*/
    }

}
