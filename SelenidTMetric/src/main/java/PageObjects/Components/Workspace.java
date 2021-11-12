package PageObjects.Components;

import PageObjects.*;
import PageObjects.WorkspaceSettings.GeneralWorkspaceSettingsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Workspace {
    private SelenideElement linkToSettingsPage = $x("//span[text()='Settings']");
    private SelenideElement linkToMembersPage = $x("//span[text()='Members']");
    private SelenideElement linkToTeamsPage = $x("//span[text()='Teams']");
    private SelenideElement linkToTagsPage = $x("//span[text()='Tags']");
    private SelenideElement linkToIntegrationsPage = $x("//span[text()='Integrations']");
    private SelenideElement linkToSubscriptionPage = $x("//span[text()='Subscription']");

    public GeneralWorkspaceSettingsPage goToGeneralWorkspaceSettingsPage(){
        linkToSettingsPage.shouldBe(Condition.visible).click();
        return new GeneralWorkspaceSettingsPage();
    }
    public MembersPage goToMembersPagePage(){
        linkToMembersPage.shouldBe(Condition.visible).click();
        return new MembersPage();
    }
    public TeamsPage goToTeamsPage(){
        linkToTeamsPage.shouldBe(Condition.visible).click();
        return new TeamsPage();
    }
    public TagsPage goToTagsPage() {
        linkToTagsPage.shouldBe(Condition.visible).click();
        return new TagsPage();
    }
    public IntegrationsPage goToIntegrationsPage() {
        linkToIntegrationsPage.shouldBe(Condition.visible).click();
        return new IntegrationsPage();
    }
    public SubscriptionPage goToSubscriptionPage() {
        linkToSubscriptionPage.shouldBe(Condition.visible).click();
        return new SubscriptionPage();
    }

}
