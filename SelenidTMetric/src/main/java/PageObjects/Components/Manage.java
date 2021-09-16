package PageObjects.Components;

import PageObjects.ClientsPage;
import PageObjects.InvoicesPage;
import PageObjects.ProjectsPage;
import PageObjects.TimeOff.TimeOffBalancesPage;
import PageObjects.TimeOff.TimeOffCalendarPage;
import PageObjects.TimeOff.TimeOffPoliciesPage;
import PageObjects.TimeOff.TimeOffRequestsPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class Manage {
    private SelenideElement linkToProjectsPage = $x("//span[text()='Projects']");
    private SelenideElement linkToClientsPage = $x("//span[text()=' Clients ']");
    private SelenideElement linkToInvoicesPage = $x("//span[text()='Invoices']");
    //TimeOff
    private SelenideElement itemTimeOff = $x("//span[text()='Time Off']");
    private SelenideElement linkToPoliciesPage = $x("//a[@class=\"nav-link dropdown-link\" and text()='Policies']");
    private SelenideElement linkToRequestsPage = $x("//a[@class=\"nav-link dropdown-link\" and text()='Requests']");
    private SelenideElement linkToBalancesPage = $x("//a[@class=\"nav-link dropdown-link\" and text()='Balances']");
    private SelenideElement linkToCalendarPage = $x("//a[@class=\"nav-link dropdown-link\" and text()='Calendar']");


    public ProjectsPage goToProjectsPage(){
        linkToProjectsPage.click();
        return new ProjectsPage();
    }
    public ClientsPage goToClientsPage(){
        linkToClientsPage.click();
        return new ClientsPage();
    }
    public InvoicesPage goToInvoicesPage(){
        linkToInvoicesPage.click();
        return new InvoicesPage();
    }
    public TimeOffPoliciesPage goToPoliciesPage(){
        actions().moveToElement(itemTimeOff).click().moveToElement(linkToPoliciesPage).click().build().perform();
        return new TimeOffPoliciesPage();
    }
    public TimeOffRequestsPage goToTimeOffRequestsPage(){
        actions().moveToElement(itemTimeOff).click().moveToElement(linkToRequestsPage).click().build().perform();
        return new TimeOffRequestsPage();
    }
    public TimeOffBalancesPage goToTimeOffBalancesPage(){
        actions().moveToElement(itemTimeOff).click().moveToElement(linkToBalancesPage).click().build().perform();
        return new TimeOffBalancesPage();
    }
    public TimeOffCalendarPage goToTimeOffCalendarPage(){
        actions().moveToElement(itemTimeOff).click().moveToElement(linkToBalancesPage).click().build().perform();
        return new TimeOffCalendarPage();
    }


}
