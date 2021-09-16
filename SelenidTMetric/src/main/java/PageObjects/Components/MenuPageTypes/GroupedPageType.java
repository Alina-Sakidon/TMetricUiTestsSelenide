package PageObjects.Components.MenuPageTypes;

import PageObjects.Components.UserHotMenu;

public class GroupedPageType
{
    public static MenuPageType time = MenuPageType.TIME;
    public static MenuPageType tasks = MenuPageType.TASKS;
    public static MenuPageType activity = MenuPageType.Activity;
    public static MenuPageType projects = MenuPageType.Projects;
    public static MenuPageType clients = MenuPageType.Clients;
    public static MenuPageType invoices = MenuPageType.Invoices;
    public static Reports reports = new Reports();
    public static TimeOffMenuGroup timeOff = new TimeOffMenuGroup();
    public static MenuPageType settings = MenuPageType.Settings;
    public static MenuPageType members = MenuPageType.Members;
    public static MenuPageType teams = MenuPageType.Teams;
    public static MenuPageType tags = MenuPageType.Tags;
    public static MenuPageType integrations = MenuPageType.Integrations;
    public static MenuPageType subscription = MenuPageType.Subscription;
    public static MenuPageType help = MenuPageType.Help;
    public static UserHotMenu userHotMenu = new UserHotMenu();
   /* public static MenuPageType myProfile = MenuPageType.MyProfile;
    public static MenuPageType manageWorkspace = MenuPageType.ManageWorkspaces;
    public static MenuPageType logout = MenuPageType.Logout;*/
}
