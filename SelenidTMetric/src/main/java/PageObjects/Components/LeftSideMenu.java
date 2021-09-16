package PageObjects.Components;

import PageObjects.*;
import PageObjects.Components.MenuPageTypes.MenuPageType;
import PageObjects.Reports.*;
import PageObjects.TimeOff.TimeOffPoliciesPage;
import PageObjects.TimeOff.TimeOffRequestsPage;
import PageObjects.UserHotMenu.MyProfilePage;

import java.util.HashMap;
import java.util.function.Function;

public class LeftSideMenu {

    private final Tasks tasks;
    private final Help help;
    private final Manage manage;
    private final Time time;
    private final AnalyzeGroup analyze;
    private final Workspace workspace;
    private final UserHotMenu userHotMenu;
    private final HashMap<MenuPageType, Function<String, BasePage>> _activators;

    public LeftSideMenu() {
        time = new Time();
        tasks = new Tasks();
        help = new Help();
        analyze = new AnalyzeGroup();
        manage = new Manage();
        workspace = new Workspace();
        userHotMenu = new UserHotMenu();

        _activators = new HashMap<MenuPageType, Function<String, BasePage>>();

        _activators.put(MenuPageType.TIME, (p) -> time.goToMyTimePage());

        _activators.put(MenuPageType.TASKS, (p) -> tasks.goToMyTasksPage());
        //reports
        _activators.put(MenuPageType.TeamSummaryReport, (p) -> analyze.goToTeamSummaryPage());
        _activators.put(MenuPageType.ActivitySummaryReport, (p) -> analyze.goToActivitySummaryPage());
        _activators.put(MenuPageType.AppUsageReport, (p) -> analyze.goToAppsUsagePage());
        _activators.put(MenuPageType.DetailedReport, (p) -> analyze.goToDetailedReportPage());
        _activators.put(MenuPageType.ProjectsSummaryReport, (p) -> analyze.goToProjectSummaryPage());
        _activators.put(MenuPageType.TasksSummaryReport, (p) -> analyze.goToTasksSummaryPage());

        _activators.put(MenuPageType.Activity, (p) -> analyze.goToMyActivityPage());
        //manage
        _activators.put(MenuPageType.Projects, (p) -> manage.goToProjectsPage());
        _activators.put(MenuPageType.Clients, (p) -> manage.goToClientsPage());
        _activators.put(MenuPageType.Invoices, (p) -> manage.goToInvoicesPage());
        //TimeOff
        _activators.put(MenuPageType.TimeOffPolicies, (p) -> manage.goToPoliciesPage());
        _activators.put(MenuPageType.TimeOffRequests, (p) -> manage.goToTimeOffRequestsPage());
        _activators.put(MenuPageType.TimeOffBalances, (p) -> manage.goToTimeOffBalancesPage());
        _activators.put(MenuPageType.TimeOffCalendar, (p) -> manage.goToTimeOffCalendarPage());
        //workspace
        _activators.put(MenuPageType.Settings, (p) -> workspace.goToWorkspaceSettingsPage());
        _activators.put(MenuPageType.Members, (p) -> workspace.goToMembersPagePage());
        _activators.put(MenuPageType.Teams, (p) -> workspace.goToTeamsPage());
        _activators.put(MenuPageType.Tags, (p) -> workspace.goToTagsPage());
        _activators.put(MenuPageType.Integrations, (p) -> workspace.goToIntegrationsPage());
        _activators.put(MenuPageType.Subscription, (p) -> workspace.goToSubscriptionPage());

        _activators.put(MenuPageType.Help, (p) -> help.goToHelpPage());
        //UserHotMenu
        _activators.put(MenuPageType.MyProfile, (p) -> userHotMenu.goToMyProfilePage());
        _activators.put(MenuPageType.TIME, (workspace) -> userHotMenu.goToMyTimeFromUserHotMenu(workspace));
        _activators.put(MenuPageType.ManageWorkspaces, (p) -> userHotMenu.goToManageWorkspacePage());
        _activators.put(MenuPageType.Logout, (p) -> userHotMenu.goToLogoutPage());

    }

   /* public <T extends BasePage> T  openT()
    {

           return (T) time.goToMyTimePage();

    }*/

    public BasePage open(MenuPageType page) {
        return open(page, null);
    }

    public MyTimePage openTime()
    {
        return (MyTimePage) open(MenuPageType.TIME);
    }
    public MyTasksPage openTasks(){
        return (MyTasksPage) open(MenuPageType.TASKS);
    }
    //reports
    public ActivitySummaryPage openActivitySummary(){
        return (ActivitySummaryPage) open(MenuPageType.ActivitySummaryReport);
    }
    public DetailedReportPage openDetailedReport(){
        return (DetailedReportPage) open(MenuPageType.DetailedReport);
    }
    public AppsUsagePage openAppsUsagePage(){
        return (AppsUsagePage) open(MenuPageType.AppUsageReport);
    }
    public ProjectsSummaryPage openProjectsSummary(){
        return (ProjectsSummaryPage) open(MenuPageType.ProjectsSummaryReport);
    }
    public TasksSummaryPage openTasksSummary(){
        return (TasksSummaryPage) open(MenuPageType.TasksSummaryReport);
    }
    public TeamSummaryPage openTeamSummary(){
        return (TeamSummaryPage) open(MenuPageType.TeamSummaryReport);
    }
    public MyActivityPage openActivity(){
        return (MyActivityPage) open(MenuPageType.Activity);
    }
    public ProjectsPage openProjects(){
        return (ProjectsPage) open(MenuPageType.Projects);
    }
    public ClientsPage openClients(){
        return (ClientsPage) open(MenuPageType.Clients);
    }
    public InvoicesPage openInvoices(){
        return (InvoicesPage) open(MenuPageType.Invoices);
    }
    //timeOff

    public TimeOffPoliciesPage openTimeOffPolicies(){
        return (TimeOffPoliciesPage) open(MenuPageType.TimeOffPolicies);
    }
    public TimeOffRequestsPage TimeOffRequests(){
        return (TimeOffRequestsPage) open(MenuPageType.TimeOffRequests);
    }


    public MyProfilePage openMyProfile(){
        return (MyProfilePage) open(MenuPageType.MyProfile);
    }

    public BasePage open(MenuPageType page, String parameter) {
            var activator = _activators.get(page);
            if (activator != null) {
                return activator.apply(parameter);
            }
            return null;
    }
}
