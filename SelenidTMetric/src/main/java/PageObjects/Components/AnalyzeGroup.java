package PageObjects.Components;

import PageObjects.*;
import PageObjects.Reports.*;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class AnalyzeGroup {
    //reports
    private SelenideElement itemReports = $x("//span[text()='Reports']");
    private SelenideElement linkProjectsSummary = $x("//a[@class='nav-link dropdown-link' and text()='Projects Summary']");
    private SelenideElement linkTasksSummary = $x("//a[@class='nav-link dropdown-link' and text()='Tasks Summary']");
    private SelenideElement linkTeamSummary = $x("//a[@class='nav-link dropdown-link' and text()='Team Summary']");
    private SelenideElement linkActivitySummary = $x("//a[@class='nav-link dropdown-link' and text()='Activity Summary']");
    private SelenideElement linkAppsUsage = $x("//a[@class='nav-link dropdown-link' and text()='Apps Usage']");
    private SelenideElement linkDetailedReport = $x("//a[@class='nav-link dropdown-link' and text()='Detailed Report']");

    //Activity
    private SelenideElement linkMyActivity = $x("//span[text()='Activity']");


    public ProjectsSummaryPage goToProjectSummaryPage(){
        actions().moveToElement(itemReports).click().moveToElement(linkProjectsSummary).click().build().perform();
        return new ProjectsSummaryPage();
    }
    public TasksSummaryPage goToTasksSummaryPage(){
        actions().moveToElement(itemReports).click().moveToElement(linkTasksSummary).click().build().perform();
        return new TasksSummaryPage();
    }

    public TeamSummaryPage goToTeamSummaryPage(){
        actions().moveToElement(itemReports).click().moveToElement(linkTeamSummary).click().build().perform();
        return new TeamSummaryPage();
    }
    public ActivitySummaryPage goToActivitySummaryPage(){
        actions().moveToElement(itemReports).click().moveToElement(linkActivitySummary).click().build().perform();
        return new ActivitySummaryPage();
    }
    public AppsUsagePage goToAppsUsagePage(){
        actions().moveToElement(itemReports).click().moveToElement(linkAppsUsage).click().build().perform();
        return new AppsUsagePage();
    }
    public DetailedReportPage goToDetailedReportPage(){
        actions().moveToElement(itemReports).click().moveToElement(linkDetailedReport).click().build().perform();
        return new DetailedReportPage();
    }
    public MyActivityPage goToMyActivityPage(){
        linkMyActivity.click();
        return new MyActivityPage();
    }

}
