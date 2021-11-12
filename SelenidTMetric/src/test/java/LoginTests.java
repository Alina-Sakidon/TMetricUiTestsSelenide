import MyProfileTests.BaseTest;
import PageObjects.*;
import PageObjects.Components.MenuPageTypes.GroupedPageType;
import PageObjects.Components.MenuPageTypes.Reports;
import PageObjects.Reports.TeamSummaryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginAdmin() throws InterruptedException {
        RestoreDbPage restoreDbPage = restoreSqlBase("NewWorkweek");
        ChooseWorkspacePage chooseWorkspacePage = goToLoginPage()
                .setEmailAndPassword("admin@tmetric.test", "111111")
                .clickLoginButton()
                .skipBrowsExtension();
        Assert.assertTrue(chooseWorkspacePage.isChooseWorkspacePageVisible());

        MyTimePage myTimePage = chooseWorkspacePage.goToWorkspace("Workweek with general and personal settings");


        TeamSummaryPage teamSummaryPage = (TeamSummaryPage) myTimePage.menu().open(Reports.teamSummary);
        Assert.assertTrue(teamSummaryPage.isTeamSummaryPageVisible());
        ProjectsPage projectsPage = (ProjectsPage) teamSummaryPage.menu().open(GroupedPageType.projects);
        Assert.assertTrue(projectsPage.isProjectsPageVisible());

    }

}
